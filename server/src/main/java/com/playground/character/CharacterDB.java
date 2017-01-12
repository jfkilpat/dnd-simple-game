package com.playground.character;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "characters")
public class CharacterDB {
    @Id
    private String id;
    private String characterJson;
}
