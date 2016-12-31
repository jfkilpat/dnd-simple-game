package com.playground.monster;

import com.playground.character.AbilityScores;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Monster {
    private MonsterType type;
    private String name;
    private AbilityScores abilityScores;
}
