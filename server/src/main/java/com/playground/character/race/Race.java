package com.playground.character.race;

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

    public static Race determineRace(RaceType race, SubRaceType subrace, Ability firstChoice, Ability secondChoice) {
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
                type = new Dragonborn();
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
                        type = new Gnome(SubRaceType.FOREST_GNOME);
                        break;
                    case ROCK_GNOME:
                        type = new Gnome(SubRaceType.ROCK_GNOME);
                        break;
                }
                break;
            case HALFELF:
                type = new HalfElf(firstChoice, secondChoice);
                break;
            case HALFORC:
                type = new HalfOrc();
                break;
            case HALFLING:
                switch (subrace) {
                    case LIGHTFOOT_HALFLING:
                        type = new Halfling(SubRaceType.LIGHTFOOT_HALFLING);
                        break;
                    case STOUT_HALFLING:
                        type = new Halfling(SubRaceType.STOUT_HALFLING);
                        break;
                }
                break;
            case TIEFLING:
                type = new Tiefling();
                break;
            case HUMAN:
                type = new Human();
                break;
        }
        return type;
    }
}
