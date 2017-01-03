package com.playground.charclass;

import java.util.Collections;

/**
 * Created by jonathankilpatrick on 1/2/17.
 */
public class Druid extends CharClass {
    public Druid() {
        super.setType(ClassTypes.DRUID);
        super.setClassHitDice("d8");
        super.setClassHitPoints(8);
        super.setClassMovement(0);
        super.setSpecial(Collections.emptyMap());
    }
}
