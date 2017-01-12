package com.playground.env;

public class GameBoardFactory {

    private static GameBoard instance = null;

    public static GameBoard get() {
        if(instance != null) return instance;
        return instance = GameBoard.builder().build();
    }

    public static void set(GameBoard gameBoard) {
        instance = gameBoard;
    }
}
