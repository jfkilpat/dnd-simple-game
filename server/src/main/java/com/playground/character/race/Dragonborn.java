package com.playground.character.race;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonathankilpatrick on 12/29/16.
 */
public class Dragonborn extends Race {

    public Dragonborn() {
        Map<Ability, Integer> racialAbilityBonus = new HashMap<>();
        racialAbilityBonus.put(Ability.STR, 2);
        racialAbilityBonus.put(Ability.CHA, 1);
        super.setRaceSpeedBonus(30);
        super.setRacialStatBonuses(racialAbilityBonus);
        super.setType(RaceType.DRAGONBORN);
        super.setSubRaceType(SubRaceType.NONE);
    }
}
