package com.playground.gameboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "gameboards")
public class GameBoardDatabase {
    @Id
    private String id;
    private String dmUserId;
    private List<String> characterIds;
    private List<String> creatureIds;
    private String gameBoardJSON;
}
