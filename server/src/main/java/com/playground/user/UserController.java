package com.playground.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/create")
    public User saveUser(
            @RequestParam String userId,
            @RequestParam String password
    ) {
        return userService.saveUser(userId, password);
    }

    @GetMapping(value = "/find/token/{tokenId}")
    public User findByTokenId(
            @PathVariable("tokenId") String tokenId
    ) {
        return userService.getUserByTokenId(tokenId);
    }

    @GetMapping(value = "/find/{userId}")
    public User findByUserId(
            @PathVariable("userId") String userId
    ) {
        return userService.getUserByUserId(userId);
    }

    @GetMapping(value = "/associate/game")
    public User attachGameToUser(
            @RequestParam String gameId,
            @RequestParam String tokenId
    ) {
        userService.associateUserToGameBoard(tokenId, gameId);
        return userService.getUserByTokenId(tokenId);
    }
}
