package com.playground.character.race;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonathankilpatrick on 1/1/17.
 */
public class Human extends Race {
    private Map<Ability, Integer> racialBonus = new HashMap<>();
    public Human() {
        racialBonus.put(Ability.STR, 1);
        racialBonus.put(Ability.CHA, 1);
        racialBonus.put(Ability.INT, 1);
        racialBonus.put(Ability.DEX, 1);
        racialBonus.put(Ability.CON, 1);
        racialBonus.put(Ability.WIS, 1);
        super.setRaceSpeedBonus(30);
        super.setRacialStatBonuses(racialBonus);
        super.setSubRaceType(SubRaceType.NONE);
        super.setType(RaceType.HUMAN);
    }
}
