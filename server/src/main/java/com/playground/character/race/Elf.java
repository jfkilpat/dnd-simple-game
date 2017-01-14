package com.playground.character.race;


import java.util.HashMap;
import java.util.Map;

public class Elf extends Race {

    public Elf(SubRaceType type) {
        Map<Ability, Integer> racialBonus = new HashMap<>();

        Integer racialSpeedBonus = 30;
        racialBonus.put(Ability.DEX, 2);
        switch (type) {
            case DARK_ELF:
                super.setSubRaceType(SubRaceType.DARK_ELF);
                racialBonus.put(Ability.CHA, 1);
                break;
            case HIGH_ELF:
                super.setSubRaceType(SubRaceType.HIGH_ELF);
                racialBonus.put(Ability.INT, 1);
                break;
            case WOOD_ELF:
                super.setSubRaceType(SubRaceType.WOOD_ELF);
                racialBonus.put(Ability.WIS, 1);
                break;
        }

        super.setRaceSpeedBonus(racialSpeedBonus);
        super.setRacialStatBonuses(racialBonus);
        super.setType(RaceType.ELF);
    }
}
