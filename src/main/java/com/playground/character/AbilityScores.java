package com.playground.character;


import lombok.Data;

@Data
public class AbilityScores {
    private Integer strength;
    private Integer strModifier;

    private Integer intelligence;
    private Integer intModifier;

    private Integer dexterity;
    private Integer dexModifier;

    private Integer wisdom;
    private Integer wisModifier;

    private Integer constitution;
    private Integer conModifier;

    private Integer charisma;
    private Integer chaModifier;

    public AbilityScores(Integer strength, Integer intelligence, Integer dexterity, Integer wisdom, Integer constitution, Integer charisma) {
        this.strength = strength;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.wisdom = wisdom;
        this.constitution = constitution;
        this.charisma = charisma;
        this.determineModifierValues();
    }


    public void determineModifierValues() {
        this.strModifier = Character.determineAbilityModifier(this.strength);

        this.intModifier = Character.determineAbilityModifier(this.intelligence);

        this.dexModifier = Character.determineAbilityModifier(this.dexterity);

        this.wisModifier = Character.determineAbilityModifier(this.wisdom);

        this.conModifier = Character.determineAbilityModifier(this.constitution);

        this.chaModifier = Character.determineAbilityModifier(this.charisma);
    }
}
