package com.playground.env;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/gameboard")
public class GameBoardController {

    @Autowired
    private GameBoardService gameBoardService;

    @GetMapping(value = "/find/{id}")
    public GameBoard getGameboardById(
            @PathVariable("id") String id
    ) {
        return gameBoardService.getGameBoardById(id);
    }

    @GetMapping(value = "/create")
    public GameBoard createStandardGameBoard() {
        return gameBoardService.createGameboard();
    }

    @GetMapping(value = "/associate/character")
    public GameBoard associateCharacterToGame(
            @RequestParam String characterId,
            @RequestParam String gameId
    ) {
        return gameBoardService.attachCharacterToGame(gameId, characterId);
    }
}
