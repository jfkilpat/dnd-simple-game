package com.playground.util;

/**
 * Created by jonathankilpatrick on 1/3/17.
 */
public class DiceRoller {
    public static Integer rollDie(String diceType) {
        Integer diceNumber = Integer.valueOf(diceType.substring(diceType.length() - 1));
        return (int) ((Math.random() * diceNumber) + 1);
    }
}
