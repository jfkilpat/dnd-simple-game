package com.playground.env;

/**
 * Created by jonathankilpatrick on 12/29/16.
 */
public class GameBoardFactory {

    private static GameBoard instance = null;

    public static GameBoard get() {
        if(instance != null) return instance;
        return instance = new GameBoard();
    }
}
