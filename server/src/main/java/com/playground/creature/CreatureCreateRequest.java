package com.playground.creature;

import com.playground.character.AbilityScores;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatureCreateRequest {
    public CreatureType type;
    public String name;
    public String size;
    public Integer hitPoints;
    public Integer armorClass;
    public AbilityScores abilityScores;
}
