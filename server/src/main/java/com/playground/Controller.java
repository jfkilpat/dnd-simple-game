package com.playground;

import com.playground.character.AbilityScores;
import com.playground.character.Character;
import com.playground.character.CreatePlayerRequest;
import com.playground.character.charclass.CharClass;
import com.playground.character.charclass.Monk;
import com.playground.creature.CreatureCreateRequest;
import com.playground.dm.DungeonMaster;
import com.playground.gameboard.GameBoard;
import com.playground.gameboard.GameBoardDatabase;
import com.playground.gameboard.GameBoardFactory;
import com.playground.creature.Creature;
import com.playground.creature.PreMadeCreatureFactory;
import com.playground.gameboard.GameBoardRepository;
import com.playground.character.race.Elf;
import com.playground.character.race.Race;
import com.playground.character.race.SubRaceType;
import com.playground.util.GameboardSaveUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/game")
public class Controller {

    private GameBoard sessionGameBoard = GameBoardFactory.get();

    private GameBoardRepository gameBoardRepository;

    @Autowired
    public Controller(GameBoardRepository gameBoardRepository) {
        this.gameBoardRepository = gameBoardRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public GameBoard createGameBoard() {
        System.out.println( "Hello World!");

        Character character = new Character(
                "Magicus Phillip",
                2,
                new Elf(SubRaceType.WOOD_ELF),
                new Monk(2),
                new AbilityScores(14,15,13,12,10,8)
        );

        sessionGameBoard = GameBoard.builder()
                .dm(new DungeonMaster("Jon", new ArrayList<Creature>()))
                .players(Collections.singletonList(character))
                .creatures(new ArrayList<>())
                .build();
        GameBoardFactory.set(sessionGameBoard);

        return sessionGameBoard;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public List<Creature> getMonsters() {
        return PreMadeCreatureFactory.get();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/dm/create")
    public GameBoard createDM (
            @RequestParam String name
    ) {
        sessionGameBoard.setDm(DungeonMaster.builder()
                .name(name)
                .recentlyCreatedCreatures(new ArrayList<>())
                .build()
        );
        return sessionGameBoard;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/player/create")
    public GameBoard createPlayer(
            CreatePlayerRequest request
    ) {
        sessionGameBoard.getPlayers().add(
                new Character(
                        request.getName(),
                        request.getLevel(),
                        Race.determineRace(request.getPlayerRace(), request.getPlayerSubRace(), request.getFirstAbilityIncrease(), request.getSecondAbilityIncrease()),
                        CharClass.determineClass(request.getPlayerClass(), request.getLevel()),
                        request.getAbilityScores()
                )
        );
        return sessionGameBoard;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/creature/create")
    public GameBoard addMonster(
            CreatureCreateRequest request

    ) {
        DungeonMaster dungeonMaster = sessionGameBoard.getDm();
        dungeonMaster.createNewMonster(
                request.getName(),
                request.getType(),
                request.getHitPoints(),
                request.getArmorClass(),
                request.getSize(),
                new AbilityScores(8,8,8,8,8,8)
        );
        return sessionGameBoard;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public void saveGameBoard() {
        GameboardSaveUtil.exportGameBoardToFile(sessionGameBoard);
        GameboardSaveUtil.importGameBoardFromFile("GameBoardJSON.json");
    }


    @GetMapping(value = "/mongo/save")
    public GameBoard saveGameBoardToMongoDb() {
        gameBoardRepository.deleteAll();

        gameBoardRepository.save(GameBoardDatabase.builder()
                .gameBoardJSON(GameboardSaveUtil.createJsonFromGameBoard(sessionGameBoard))
                .build()
        );

        List<GameBoardDatabase> gameBoards = gameBoardRepository.findAll();
        for (GameBoardDatabase gameBoard : gameBoards) {
            log.info(gameBoard.toString());
            GameBoardFactory.set(GameboardSaveUtil.setupGameBoardFromJson(gameBoard.getGameBoardJSON()));
        }
        return sessionGameBoard;
    }

}
