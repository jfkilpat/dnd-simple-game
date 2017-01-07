package com.playground.env;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameBoardDatabase {
    @Id
    private long id;
    private String gameBoardJSON;
}
