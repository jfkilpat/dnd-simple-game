package com.playground.dm;

import com.playground.character.AbilityScores;
import com.playground.creature.Creature;
import com.playground.creature.CreatureType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DungeonMaster{

    private String name;

    private List<Creature> recentlyCreatedCreatures;

    public DungeonMaster(String name, List<Creature> recentlyCreatedCreatures) {
        this.name = name;
        this.recentlyCreatedCreatures = recentlyCreatedCreatures;
    }

    public void createNewMonster(
            String name,
            CreatureType type,
            Integer hitPoints,
            Integer armorClass,
            String size,
            AbilityScores abilityScores
    ) {
        recentlyCreatedCreatures.add(Creature.builder()
            .name(name)
            .type(type)
            .hitPoints(hitPoints)
            .armorClass(armorClass)
            .size(size)
            .abilityScores(abilityScores)
            .build());
    }
}
