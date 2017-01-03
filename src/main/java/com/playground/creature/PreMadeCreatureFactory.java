package com.playground.creature;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.playground.character.AbilityScores;
import com.playground.monsterindex.MonsterIndex;
import com.playground.monsterindex.MonsterIndexAction;
import com.playground.monsterindex.MonsterIndexLendAction;
import com.playground.monsterindex.MonsterIndexSpcAction;
import com.playground.util.StringResources;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PreMadeCreatureFactory {

    private static List<Creature> creatures = null;

    private static Gson gson = new Gson();

    public static List<Creature> get() {
        if(creatures == null) {
            String json = StringResources.monsterIndexJson;
            Type collectionType = new TypeToken<Collection<MonsterIndex>>(){}.getType();
            Collection<MonsterIndex> monsterIndexList = gson.fromJson(json, collectionType);
            creatures = monsterIndexList.parallelStream().map(PreMadeCreatureFactory::createMonster).collect(Collectors.toList());
        }
        return creatures;
    }


    private static Creature createMonster(MonsterIndex monsterIndex) {
        return Creature.builder()
                .type(CreatureType.determineMonsterType(monsterIndex.getType()))
                .name(monsterIndex.getName())
                .size(monsterIndex.getSize())
                .hitPoints(monsterIndex.getHitPoints())
                .armorClass(monsterIndex.getArmorClass())
                .abilityScores(new AbilityScores(
                        monsterIndex.getStrength(),
                        monsterIndex.getIntelligence(),
                        monsterIndex.getDexterity(),
                        monsterIndex.getWisdom(),
                        monsterIndex.getConstitution(),
                        monsterIndex.getCharisma()
                ))
                .creatureActions(monsterIndex.getActions().stream().map(PreMadeCreatureFactory::createCreatureAction).collect(Collectors.toList()))
                .creatureSpecialAbilities(monsterIndex.getSpecialAbilities().stream().map(PreMadeCreatureFactory::createCreatureSpecial).collect(Collectors.toList()))
                .creatureLegendaryActions(monsterIndex.getLegendaryActions().stream().map(PreMadeCreatureFactory::createCreatureLegend).collect(Collectors.toList()))
                .build();
    }

    private static Creature.CreatureAction createCreatureAction(MonsterIndexAction action) {
        return Creature.CreatureAction.builder()
                .name(action.getName())
                .desc(action.getDesc())
                .attackBonus(action.getAttackBonus())
                .damageDice(action.getDamageDice())
                .damageBonus(action.getDamageBonus())
                .build();
    }

    private static Creature.CreatureSpecial createCreatureSpecial(MonsterIndexSpcAction action) {
        return Creature.CreatureSpecial.builder()
                .name(action.getName())
                .desc(action.getDesc())
                .attackBonus(action.getAttackBonus())
                .build();
    }

    private static Creature.CreatureLegend createCreatureLegend(MonsterIndexLendAction action) {
        return Creature.CreatureLegend.builder()
                .name(action.getName())
                .desc(action.getDesc())
                .attackBonus(action.getAttackBonus())
                .build();
    }
}
