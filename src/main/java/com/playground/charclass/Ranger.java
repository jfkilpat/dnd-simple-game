package com.playground.charclass;

import java.util.Collections;

/**
 * Created by jonathankilpatrick on 1/2/17.
 */
public class Ranger extends CharClass {
    public Ranger() {
        super.setType(ClassTypes.RANGER);
        super.setClassHitDice("d10");
        super.setClassHitPoints(10);
        super.setClassMovement(0);
        super.setSpecial(Collections.emptyMap());
    }
}
