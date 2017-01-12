package com.playground.creature;

import java.util.Arrays;

/**
 * Created by jonathankilpatrick on 12/29/16.
 */
public enum CreatureType {
    BEAST("beast"),
    HUMAN("humanoid"),
    CONSTRUCT("construct"),
    DRAGON("dragon"),
    MONSTROSITY("monstrosity"),
    ELEMENTAL("elemental"),
    UNDEAD("undead"),
    ABERRATION("aberration"),
    PLANT("plant"),
    FIEND("fiend"),
    OOZE("ooze"),
    FEY("fey"),
    GIANT("giant"),
    CELESTIAL("celestial"),
    SWARM_TINY_BEASTS("swarm of Tiny beasts");

    private String value;

    CreatureType(String value) {
        this.value = value;
    }

    public static CreatureType determineMonsterType(String type) {
        return Arrays.stream(CreatureType.values())
                .filter(monsterType -> monsterType.value.equals(type))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
