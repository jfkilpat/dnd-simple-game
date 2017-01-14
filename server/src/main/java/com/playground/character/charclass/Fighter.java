package com.playground.character.charclass;

import java.util.Collections;

/**
 * Created by jonathankilpatrick on 1/2/17.
 */
public class Fighter extends CharClass {
    public Fighter() {
        super.setType(ClassTypes.FIGHTER);
        super.setClassHitDice("d10");
        super.setClassHitPoints(10);
        super.setClassMovement(0);
        super.setSpecial(Collections.emptyMap());
    }
}
