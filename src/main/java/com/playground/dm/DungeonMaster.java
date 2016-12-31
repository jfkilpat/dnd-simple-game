package com.playground.dm;

import com.playground.character.AbilityScores;
import com.playground.monster.Monster;
import com.playground.monster.MonsterType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DungeonMaster {

    private String name;

    private List<Monster> recentlyCreatedMonsters;

    public DungeonMaster(String name, List<Monster> recentlyCreatedMonsters) {
        this.name = name;
        this.recentlyCreatedMonsters = recentlyCreatedMonsters;
    }

    public void createNewMonster(String name, MonsterType type, AbilityScores abilityScores) {
        recentlyCreatedMonsters.add(Monster.builder()
            .name(name)
            .type(type)
            .abilityScores(abilityScores)
            .build());
    }
}
