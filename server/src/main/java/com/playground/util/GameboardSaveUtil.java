package com.playground.util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.playground.gameboard.GameBoard;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Slf4j
public class GameboardSaveUtil {

    private static final String gameSaveName = "GameBoardJSON.json";

    private static Gson gson = new Gson();

    public static String createJsonFromGameBoard(GameBoard gameBoard) {
        return gson.toJson(gameBoard);
    }

    public static GameBoard setupGameBoardFromJson(String env) {
        try {
            return gson.fromJson(env, GameBoard.class);
        } catch (JsonSyntaxException e) {
            log.error("Corrupted environment", e);
            return null;
        }
    }

    public static GameBoard importGameBoardFromFile(String envFileName) {
        try {
            log.info("Creating GameBoard...");
            BufferedReader reader = new BufferedReader(
                    new FileReader(envFileName)
            );
            return setupGameBoardFromJson(reader.readLine());
        } catch (IOException e) {
            log.error("Error Creating GameBoard From file...", e);
            return null;
        }
    }

    public static void exportGameBoardToFile(GameBoard gameBoard) {
        try {
            log.info("Reading Gameboard File...");
            FileWriter fileWriter = new FileWriter(gameSaveName);
            fileWriter.write(createJsonFromGameBoard(gameBoard));
            fileWriter.close();
            log.info("Finished Writing Gameboard to JSON...");
        } catch (IOException e) {
            log.error("Error Writing GameBoard to file...", e);
        }
    }
}
