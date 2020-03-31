package com.innovation.game.bingo.repository;

import com.innovation.game.bingo.model.Bingo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BingoRepository extends MongoRepository<Bingo, String> {
    List<Bingo> findByUsername(String username);

    Long countByUsername(String username);
}
