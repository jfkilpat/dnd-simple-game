package com.playground.monster;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonsterIndex {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("size")
    @Expose
    public String size;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("subtype")
    @Expose
    public String subtype;
    @SerializedName("alignment")
    @Expose
    public String alignment;
    @SerializedName("armor_class")
    @Expose
    public Integer armorClass;
    @SerializedName("hit_points")
    @Expose
    public Integer hitPoints;
    @SerializedName("hit_dice")
    @Expose
    public String hitDice;
    @SerializedName("speed")
    @Expose
    public String speed;
    @SerializedName("strength")
    @Expose
    public Integer strength;
    @SerializedName("dexterity")
    @Expose
    public Integer dexterity;
    @SerializedName("constitution")
    @Expose
    public Integer constitution;
    @SerializedName("intelligence")
    @Expose
    public Integer intelligence;
    @SerializedName("wisdom")
    @Expose
    public Integer wisdom;
    @SerializedName("charisma")
    @Expose
    public Integer charisma;
    @SerializedName("constitution_save")
    @Expose
    public Integer constitutionSave;
    @SerializedName("intelligence_save")
    @Expose
    public Integer intelligenceSave;
    @SerializedName("wisdom_save")
    @Expose
    public Integer wisdomSave;
    @SerializedName("history")
    @Expose
    public Integer history;
    @SerializedName("perception")
    @Expose
    public Integer perception;
    @SerializedName("damage_vulnerabilities")
    @Expose
    public String damageVulnerabilities;
    @SerializedName("damage_resistances")
    @Expose
    public String damageResistances;
    @SerializedName("damage_immunities")
    @Expose
    public String damageImmunities;
    @SerializedName("condition_immunities")
    @Expose
    public String conditionImmunities;
    @SerializedName("senses")
    @Expose
    public String senses;
    @SerializedName("languages")
    @Expose
    public String languages;
    @SerializedName("challenge_rating")
    @Expose
    public String challengeRating;
    @SerializedName("special_abilities")
    @Expose
    public List<MonsterIndexSpcAction> specialAbilities = new ArrayList<>();
    @SerializedName("actions")
    @Expose
    public List<MonsterIndexAction> actions = new ArrayList<>();
    @SerializedName("legendary_actions")
    @Expose
    public List<MonsterIndexLendAction> legendaryActions = new ArrayList<>();

}
