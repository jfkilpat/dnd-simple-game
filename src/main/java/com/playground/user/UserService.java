package com.playground.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(String userId, String password) {
        User user = userRepository.findByUserId(userId);
        if(!Optional.ofNullable(user).isPresent()) {
            user = User.builder()
                    .userId(userId)
                    .password(password)
                    .characterIds(new ArrayList<>())
                    .gameBoardIds(new ArrayList<>())
                    .build();
            return userRepository.save(user);
        }
        return user;
    }

    public User getUserByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    public User getUserByTokenId(String id) {
        return userRepository.findById(id);
    }

    public void associateUserToGameBoard(String tokenid, String gameBoardId) {
        User user = userRepository.findById(tokenid);
        user.getGameBoardIds().add(gameBoardId);
        userRepository.save(user);
    }
}
