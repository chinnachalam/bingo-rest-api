package com.innovation.game.bingo.repository;

import com.innovation.game.bingo.model.Session;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface SessionRepository extends MongoRepository<Session, String> {
}
