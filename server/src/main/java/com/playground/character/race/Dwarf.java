package com.playground.character.race;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonathankilpatrick on 12/29/16.
 */
public class Dwarf extends Race {
    public Dwarf(SubRaceType type) {
        Map<Ability, Integer> racialAbilityBonues = new HashMap<>();
        racialAbilityBonues.put(Ability.CON, 2);
        switch (type) {
            case HILL_DWARF:
                racialAbilityBonues.put(Ability.WIS, 1);
                break;
            case MOUNTAIN_DWARF:
                racialAbilityBonues.put(Ability.STR, 2);
                break;
            case NONE:
                break;
        }
        super.setRacialStatBonuses(racialAbilityBonues);
        super.setType(RaceType.DWARF);
        super.setSubRaceType(type);
        super.setRaceSpeedBonus(25);
    }
}
