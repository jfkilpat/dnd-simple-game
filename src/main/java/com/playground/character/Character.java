package com.playground.character;

import com.playground.charclass.CharClass;
import com.playground.charclass.Monk;
import com.playground.race.Race;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
public class Character implements Serializable {
    private String name;
    private Integer level;
    private Race race;
    private CharClass charclass;
    private Integer initiative;
    private Integer tempHitPoints;
    private Integer maxHitPoints;
    private Integer speed;
    private String hitDice; //determine during construction
    private Integer armorClass;
    private Integer proficiency;
    private Map<String, Integer> specials;

    private AbilityScores abilityScores;
    private Map<EquipmentType, String> equipmentMap = new HashMap<>();

    //Background info?

    public Character (
            String name,
            Integer level,
            Race race,
            CharClass charclass,
            AbilityScores abilityScores
    ) {
        this.name = name;
        this.level = level;
        this.race = race;
        this.charclass = charclass;
        this.abilityScores = abilityScores;
        determineRacialAbilityMod();

        this.initiative = abilityScores.getDexModifier();

        this.maxHitPoints = this.charclass.getClassHitPoints() + this.abilityScores.getConModifier();
        this.tempHitPoints = this.maxHitPoints;

        this.hitDice = this.level + this.charclass.getClassHitDice();

        this.proficiency = determineProfBonus(this.level);
        this.speed = this.race.getRaceSpeedBonus() + this.charclass.getClassMovement();
        this.specials = this.charclass.getSpecial();

        determineArmorClass();
    }

    private void determineRacialAbilityMod() {
        for (Map.Entry<Race.Ability, Integer> entry : this.race.getRacialStatBonuses().entrySet()) {
            switch (entry.getKey()) {
                case STR:
                    this.abilityScores.setStrength(this.abilityScores.getStrength() + entry.getValue());
                    break;
                case INT:
                    this.abilityScores.setIntelligence(this.abilityScores.getIntelligence() + entry.getValue());
                    break;
                case WIS:
                    this.abilityScores.setWisdom(this.abilityScores.getWisdom() + entry.getValue());
                    break;
                case CON:
                    this.abilityScores.setConstitution(this.abilityScores.getConstitution() + entry.getValue());
                    break;
                case CHA:
                    this.abilityScores.setCharisma(this.abilityScores.getCharisma() + entry.getValue());
                    break;
                case DEX:
                    this.abilityScores.setDexterity(this.abilityScores.getDexterity() + entry.getValue());
                    break;
                default:
                    break;
            }
        }
        this.getAbilityScores().determineModifierValues();
    }

    public static Integer determineProfBonus(Integer currentLevel) {
        if(currentLevel >= 1 && currentLevel <= 4) {
            return 2;
        } else if(currentLevel >= 5 && currentLevel <= 8) {
            return 3;
        } else if(currentLevel >= 9 && currentLevel <= 12) {
            return 4;
        } else if(currentLevel >= 13 && currentLevel <= 16) {
            return 5;
        } else {
            return 6;
        }
    }

    public static Integer determineAbilityModifier(Integer value) {
        if(Integer.valueOf(1).equals(value)){
            return -5;
        } else if(Integer.valueOf(2).equals(value) || Integer.valueOf(3).equals(value)) {
            return -4;
        } else if(Integer.valueOf(4).equals(value) || Integer.valueOf(5).equals(value)) {
            return -3;
        } else if(Integer.valueOf(6).equals(value) || Integer.valueOf(7).equals(value)) {
            return -2;
        } else if(Integer.valueOf(8).equals(value) || Integer.valueOf(9).equals(value)) {
            return -1;
        } else if(Integer.valueOf(10).equals(value) || Integer.valueOf(11).equals(value)) {
            return 0;
        } else if(Integer.valueOf(12).equals(value) || Integer.valueOf(13).equals(value)) {
            return 1;
        } else if(Integer.valueOf(14).equals(value) || Integer.valueOf(15).equals(value)) {
            return 2;
        } else if(Integer.valueOf(16).equals(value) || Integer.valueOf(17).equals(value)) {
            return 3;
        } else if(Integer.valueOf(18).equals(value) || Integer.valueOf(19).equals(value)) {
            return 4;
        } else if(Integer.valueOf(20).equals(value) || Integer.valueOf(21).equals(value)) {
            return 5;
        } else {
            return 6;
        }
    }

    private void determineArmorClass() {
        if(this.charclass.getClass().equals(Monk.class)){
            this.armorClass = 10 + this.abilityScores.getDexModifier() + this.abilityScores.getWisModifier();
        }

        //Barb class stuff

        if(equipmentMap.containsKey(EquipmentType.ARMOR)) {
            String armor = equipmentMap.get(EquipmentType.ARMOR);
            if(armor.compareTo("Leather") == 0) {
                this.armorClass = 11 + this.abilityScores.getDexModifier();
            } else if(armor.compareTo("Chain") == 0) {
                this.armorClass = 13 + this.abilityScores.getDexModifier() > 2 ? 2 : this.abilityScores.getDexterity();
            } else if(armor.compareTo("Plate") == 0) {
                this.armorClass = 18;
            } else if(armor.compareTo("Leather") == 0) {
                this.armorClass = 11 + this.abilityScores.getDexModifier();
            }
        }
    }
}
