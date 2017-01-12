package com.playground.race;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonathankilpatrick on 1/1/17.
 */
public class HalfElf extends Race {
    private Map<Ability, Integer> racialBonus = new HashMap<>();
    public HalfElf(Ability firstIncreace, Ability secondIncreace) {
        racialBonus.put(Ability.CHA, 2);

        if(firstIncreace.equals(secondIncreace)) {
            racialBonus.put(firstIncreace, 2);
        } else {
            racialBonus.put(firstIncreace, 1);
            racialBonus.put(secondIncreace, 1);
        }

        super.setRaceSpeedBonus(30);
        super.setRacialStatBonuses(racialBonus);
        super.setSubRaceType(SubRaceType.NONE);
        super.setType(RaceType.HALFELF);
    }
}
