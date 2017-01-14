package com.playground.character.charclass;

import java.util.Collections;

public class Monk extends CharClass {
    private Integer kiPoints = 0;
    private Integer movementBonus = 0;

    public Monk (Integer currentLevel) {
        this.kiPoints = determineNumOfKiPoints(currentLevel);
        this.movementBonus = determineMovementSpeed(currentLevel);

        super.setType(ClassTypes.MONK);
        super.setClassHitDice("d8");
        super.setClassHitPoints(8);
        super.setClassMovement(this.movementBonus);
        super.setSpecial(Collections.singletonMap("Ki", this.kiPoints));
    }

    public Integer determineMovementSpeed(Integer currentLevel) {
        if(Integer.valueOf(1).equals(currentLevel)) {
            return 0;
        } else if(currentLevel >= 2 && currentLevel <= 5) {
            return 10;
        } else if(currentLevel >= 6 && currentLevel <= 9) {
            return 15;
        } else if(currentLevel >= 10 && currentLevel <= 13) {
            return 20;
        } else if(currentLevel >= 14 && currentLevel <= 17) {
            return 25;
        } else {
            return 30;
        }
    }

    public Integer determineNumOfKiPoints(Integer currentLevel) {
        if(Integer.valueOf(1).equals(currentLevel)) {
            return 0;
        } else {
            return currentLevel;
        }
    }
}
