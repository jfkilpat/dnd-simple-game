package com.playground;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.playground.character.AbilityScores;
import com.playground.character.Character;
import com.playground.charclass.CharClass;
import com.playground.charclass.Monk;
import com.playground.dm.DungeonMaster;
import com.playground.env.GameBoard;
import com.playground.env.GameBoardFactory;
import com.playground.monster.Monster;
import com.playground.monster.MonsterType;
import com.playground.race.Elf;
import com.playground.race.Race;
import com.playground.race.SubRaceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

@RestController
@Slf4j
@RequestMapping(path = "/game")
public class Controller {

    private GameBoard currentGameBoard = GameBoardFactory.get();

    private Gson gson = new Gson();

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

        currentGameBoard = GameBoard.builder()
                .dm(new DungeonMaster("Jon", new ArrayList<Monster>()))
                .players(Collections.singletonList(character))
                .monsters(new ArrayList<>())
                .build();

        String env = createEnvironmentGson();
        setUpEnvironmentFromGson(env);

        return currentGameBoard;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/dm/create")
    public GameBoard createDM (
            @RequestParam String name
    ) {
        currentGameBoard.setDm(DungeonMaster.builder()
                .name(name)
                .recentlyCreatedMonsters(new ArrayList<>())
                .build()
        );
        return currentGameBoard;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/player/create")
    public GameBoard createPlayer(
            CreatePlayerRequest request
    ) {
        currentGameBoard.getPlayers().add(
                new Character(
                        request.getName(),
                        request.getLevel(),
                        Race.determineRace(request.getPlayerRace(), request.getPlayerSubRace()),
                        CharClass.determineClass(request.getPlayerClass(), request.getLevel()),
                        request.getAbilityScores()
                )
        );
        return currentGameBoard;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/monster/create")
    public GameBoard addMonster(
            @RequestParam String monsterType,
            @RequestParam String name
    ) {
        DungeonMaster dungeonMaster = currentGameBoard.getDm();
        dungeonMaster.createNewMonster(name, MonsterType.valueOf(monsterType), new AbilityScores(8,8,8,8,8,8));
        return currentGameBoard;
    }

    public String createEnvironmentGson() {
        return this.gson.toJson(currentGameBoard);
    }

    public void setUpEnvironmentFromGson(String env) {
        try {
            this.currentGameBoard = this.gson.fromJson(env, GameBoard.class);
        } catch (JsonSyntaxException e) {
            log.error("Corrupted environment", e);
        }
    }

    public void createGameBoardFromFile(String envFileName) {
        try {
            log.info("Creating GameBoard...");
            BufferedReader reader = new BufferedReader(
                    new FileReader("EnvironmentGSON.json")
            );
            setUpEnvironmentFromGson(reader.readLine());
        } catch (IOException e) {
            log.error("Error Creating GameBoard From file...", e);
        }
    }

    public void writeGameBoardToFile() {
        try {
            log.info("Reading Gameboard File...");
            FileWriter fileWriter = new FileWriter("EnvironmentGSON.json");
            fileWriter.write(createEnvironmentGson());
            fileWriter.close();
        } catch (IOException e) {
            log.error("Error Writing GameBoard to file...", e);
        }
    }
}
