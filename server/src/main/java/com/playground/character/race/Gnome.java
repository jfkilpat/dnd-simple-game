package com.playground.character.race;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonathankilpatrick on 1/1/17.
 */
public class Gnome extends Race {
    private Map<Ability, Integer> racialBonus = new HashMap<>();
    public Gnome(SubRaceType subRaceType) {
        racialBonus.put(Ability.INT, 2);
        switch (subRaceType) {
            case FOREST_GNOME:
                racialBonus.put(Ability.DEX, 2);
                break;
            case ROCK_GNOME:
                racialBonus.put(Ability.CON, 1);
                break;
            case NONE:
                break;
        }
        super.setRaceSpeedBonus(25);
        super.setType(RaceType.GNOME);
        super.setSubRaceType(subRaceType);
        super.setRacialStatBonuses(racialBonus);
    }
}
