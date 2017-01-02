package com.playground.race;

import sun.plugin.net.protocol.jar.CachedJarURLConnection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonathankilpatrick on 1/1/17.
 */
public class Tiefling extends Race {
    private Map<Ability, Integer> racialBonus = new HashMap<>();
    public Tiefling() {
        racialBonus.put(Ability.INT, 1);
        racialBonus.put(Ability.CHA, 2);
        super.setRaceSpeedBonus(30);
        super.setRacialStatBonuses(racialBonus);
        super.setSubRaceType(SubRaceType.NONE);
        super.setType(RaceType.TIEFLING);
    }
}
