package com.playground.character;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends MongoRepository<CharacterDB, String> {
    List<CharacterDB> findAllById(List<String> ids);
}
