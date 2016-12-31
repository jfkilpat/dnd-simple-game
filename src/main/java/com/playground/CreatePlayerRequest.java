package com.playground;

import com.playground.character.AbilityScores;
import com.playground.charclass.ClassTypes;
import com.playground.race.RaceType;
import com.playground.race.SubRaceType;
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
}
