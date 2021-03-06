package com.playground.monsterindex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonsterIndexAction {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("desc")
    @Expose
    public String desc;
    @SerializedName("attack_bonus")
    @Expose
    public Integer attackBonus;
    @SerializedName("damage_dice")
    @Expose
    public String damageDice;
    @SerializedName("damage_bonus")
    @Expose
    public Integer damageBonus;
}
