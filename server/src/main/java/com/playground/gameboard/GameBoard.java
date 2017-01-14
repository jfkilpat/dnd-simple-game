package com.playground.gameboard;

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
    public DungeonMaster dm;
    public List<Character> players;
    public List<Creature> creatures;
}
