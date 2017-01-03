package com.playground.env;

import java.util.Date;

public class GameBoardFactory {

    private static GameBoard instance = null;

    public static GameBoard get() {
        if(instance != null) return instance;
        return instance = GameBoard.builder().timestamp(new Date(System.currentTimeMillis())).build();
    }
}
