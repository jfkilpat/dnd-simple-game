package com.playground.race;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonathankilpatrick on 1/1/17.
 */
public class HalfOrc extends Race {
    private Map<Ability, Integer> racialBonus = new HashMap<>();
    public HalfOrc() {
        racialBonus.put(Ability.STR, 2);
        racialBonus.put(Ability.CON, 1);
        super.setRaceSpeedBonus(30);
        super.setRacialStatBonuses(racialBonus);
        super.setType(RaceType.HALFORC);
        super.setSubRaceType(SubRaceType.NONE);
    }
}
