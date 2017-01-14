package com.playground.gameboard;

import com.playground.character.Character;
import com.playground.character.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameBoardService {

    @Autowired
    private GameBoardRepository gameBoardRepository;

    @Autowired
    private CharacterService characterService;

    public GameBoard getGameBoardById(String id) {
        GameBoardDatabase gameBoardDatabase = gameBoardRepository.findOne(id);
        GameBoard gameBoard = GameBoard.builder().build();
        if(Optional.ofNullable(gameBoardDatabase).isPresent()) {
            List<Character> characters = new ArrayList<>();
            characters.addAll(characterService.getCharactersByIds(gameBoardDatabase.getCharacterIds()));


            gameBoard = GameBoard.builder()
                    .players(characters)
                    .dm(null)
                    .creatures(new ArrayList<>())
                    .build();
        }
        return gameBoard;
    }

    public GameBoard createGameboard() {
        GameBoardDatabase gmdb = GameBoardDatabase.builder()
                .characterIds(new ArrayList<>())
                .creatureIds(new ArrayList<>())
                .dmUserId(null)
                .build();
        gameBoardRepository.save(gmdb);
        return GameBoard.builder()
                .creatures(new ArrayList<>())
                .players(new ArrayList<>())
                .dm(null)
                .build();
    }
    
    public GameBoard attachCharacterToGame(String gameId, String charId) {
        GameBoardDatabase gameBoardDatabase = gameBoardRepository.findOne(gameId);
        gameBoardDatabase.getCharacterIds().add(charId);
        gameBoardDatabase = gameBoardRepository.save(gameBoardDatabase);
        return GameBoard.builder()
                .build();
    }
}
