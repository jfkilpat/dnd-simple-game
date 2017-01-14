package com.playground.character.charclass;

import java.util.Collections;

public class Bard extends CharClass {
    public Bard(Integer currentLevel) {
        super.setType(ClassTypes.BARD);
        super.setClassHitDice("d8");
        super.setClassHitPoints(8);
        super.setClassMovement(0);
        super.setSpecial(Collections.singletonMap("Spell Slots", this.determineBardSpellSlots(currentLevel)));
    }

    public Integer determineBardSpellSlots(Integer level) {
        if(level >= 1 && level <= 9){
            return level + 3;
        } else if(Integer.valueOf(10).equals(level)) {
            return 14;
        } else if(Integer.valueOf(11).equals(level) || Integer.valueOf(12).equals(level)) {
            return 15;
        } else if(Integer.valueOf(13).equals(level)) {
            return 16;
        } else if(Integer.valueOf(14).equals(level)) {
            return 18;
        } else if(Integer.valueOf(15).equals(level) || Integer.valueOf(16).equals(level)) {
            return 19;
        } else if(Integer.valueOf(17).equals(level)) {
            return 20;
        } else {
            return 22;
        }
    }
}
