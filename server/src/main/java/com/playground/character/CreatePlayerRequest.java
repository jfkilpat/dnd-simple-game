package com.playground.character;

import com.playground.character.charclass.ClassTypes;
import com.playground.character.race.Race;
import com.playground.character.race.RaceType;
import com.playground.character.race.SubRaceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlayerRequest {
    private String name;
    private Integer level;
    private RaceType playerRace;
    private SubRaceType playerSubRace;
    private ClassTypes playerClass;
    private AbilityScores abilityScores;
    private Race.Ability firstAbilityIncrease;
    private Race.Ability secondAbilityIncrease;
}
