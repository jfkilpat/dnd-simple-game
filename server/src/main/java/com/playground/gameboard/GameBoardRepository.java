package com.playground.gameboard;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameBoardRepository extends MongoRepository<GameBoardDatabase, String> {
}
