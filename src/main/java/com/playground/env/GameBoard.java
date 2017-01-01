package com.playground.env;

import com.playground.character.Character;
import com.playground.dm.DungeonMaster;
import com.playground.creature.Creature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameBoard {
    DungeonMaster dm;
    List<Character> players;
    List<Creature> creatures;

}
