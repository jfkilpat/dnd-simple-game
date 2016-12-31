package com.playground.race;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Race {
    private RaceType type;
    private SubRaceType subRaceType;
    private Integer raceSpeedBonus;
    private Map<Ability, Integer> racialStatBonuses;

    public enum Ability {
        STR,
        INT,
        WIS,
        CON,
        CHA,
        DEX
    }

    public static Race determineRace(RaceType race, SubRaceType subrace) {
        Race type = null;
        switch (race) {
            case ELF:
                switch (subrace) {
                    case DARK_ELF:
                        type = new Elf(SubRaceType.DARK_ELF);
                        break;
                    case HIGH_ELF:
                        type = new Elf(SubRaceType.HIGH_ELF);
                        break;
                    case WOOD_ELF:
                        type = new Elf(SubRaceType.WOOD_ELF);
                        break;
                }
                break;
            case DRAGONBORN:
                break;
            case DWARF:
                switch (subrace) {
                    case HILL_DWARF:
                        type = new Dwarf(SubRaceType.HILL_DWARF);
                        break;
                    case MOUNTAIN_DWARF:
                        type = new Dwarf(SubRaceType.MOUNTAIN_DWARF);
                        break;
                }
                break;
            case GNOME:
                switch (subrace) {
                    case FOREST_GNOME:
                        break;
                    case ROCK_GNOME:
                }
                break;
            case HALFELF:
                break;
            case HALFORC:
                break;
            case HALFLING:
                switch (subrace) {
                    case LIGHTFOOT_HALFLING:
                        break;
                    case STOUT_HALFLING:
                        break;
                }
                break;
            case TIEFLING:
                break;
            case HUMAN:
                break;
        }
        return type;
    }
}
