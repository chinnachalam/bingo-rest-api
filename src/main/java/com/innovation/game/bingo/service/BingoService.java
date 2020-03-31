package com.innovation.game.bingo.service;

import com.innovation.game.bingo.model.Bingo;
import com.innovation.game.bingo.repository.BingoRepository;
import com.innovation.game.bingo.util.BingoGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BingoService {

    @Autowired
    private BingoGenerator bingoGenerator;
    @Autowired
    private BingoRepository bingoRepository;

    public List<Integer> generateBingo(String username) {
        Bingo bingo = new Bingo();
        bingo.setUsername(username);
        bingo.setBingoNumber(bingoGenerator.generateBingo());

        return bingoRepository.save(bingo).getBingoNumber();
    }

    public Long getBingoCount(String username) {
        return bingoRepository.countByUsername(username);
    }

    public List<List<Integer>> getAllBingos(String username) {
        List<Bingo> bingos = bingoRepository.findByUsername(username);
        if (bingos != null && !bingos.isEmpty()) {
            return bingos.stream().map(it -> it.getBingoNumber()).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }

    }
}
