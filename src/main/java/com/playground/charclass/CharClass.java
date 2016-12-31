package com.playground.charclass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharClass {
    private ClassTypes type;
    private String classHitDice;
    private Integer classHitPoints;
    private Integer classMovement;
    private Map<String, Integer> special;

    public static CharClass determineClass(ClassTypes playerClass, Integer level) {
        CharClass classType = null;
        switch (playerClass) {
            case BARD:
                break;
            case CLERIC:
                break;
            case DRUID:
                break;
            case FIGHTER:
                break;
            case MONK:
                classType = new Monk(level);
                break;
            case PALADIN:
                break;
            case RNGER:
                break;
            case ROGUE:
                break;
            case SORCERER:
                break;
            case WARLOCK:
                break;
            case WIZARD:
                break;
        }
        return classType;
    }
}
