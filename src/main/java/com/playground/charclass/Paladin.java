package com.playground.charclass;

import java.util.Collections;

/**
 * Created by jonathankilpatrick on 1/2/17.
 */
public class Paladin extends CharClass {
    public Paladin() {
        super.setType(ClassTypes.PALADIN);
        super.setClassHitDice("d10");
        super.setClassHitPoints(10);
        super.setClassMovement(0);
        super.setSpecial(Collections.emptyMap());
    }
}
