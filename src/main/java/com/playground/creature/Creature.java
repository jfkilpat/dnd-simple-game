package com.playground.creature;

import com.playground.character.AbilityScores;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Creature {
    private CreatureType type;
    private String name;
    private String size;
    private Integer hitPoints;
    private Integer armorClass;
    private AbilityScores abilityScores;
    private List<CreatureAction> creatureActions;
    private List<CreatureSpecial> creatureSpecialAbilities;
    private List<CreatureLegend> creatureLegendaryActions;

    @Data
    @Builder
    static class CreatureAction {
        private String name;
        private String desc;
        private Integer attackBonus;
        private String damageDice;
        private Integer damageBonus;
    }

    @Data
    @Builder
    static class CreatureSpecial {
        private String name;
        private String desc;
        private Integer attackBonus;
    }

    @Data
    @Builder
    static class CreatureLegend {
        private String name;
        private String desc;
        private Integer attackBonus;
    }
}
