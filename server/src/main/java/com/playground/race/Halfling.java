package com.playground.race;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonathankilpatrick on 1/1/17.
 */
public class Halfling extends Race {
    private Map<Ability, Integer> racialBonus = new HashMap<>();
    public Halfling(SubRaceType type) {
        racialBonus.put(Ability.DEX, 2);
        switch (type) {
            case LIGHTFOOT_HALFLING:
                racialBonus.put(Ability.CHA, 1);
                break;
            case STOUT_HALFLING:
                racialBonus.put(Ability.CON, 1);
                break;
        }
        super.setRaceSpeedBonus(30);
        super.setSubRaceType(type);
        super.setType(RaceType.HALFLING);
        super.setRacialStatBonuses(racialBonus);
    }
}
