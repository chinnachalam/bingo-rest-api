package com.innovation.game.bingo.util;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BingoGenerator {
    public static final int WIDTH = 5;
    public static final int HEIGHT = 5;
    public static final int SIZE = WIDTH * HEIGHT;

    public List<Integer> generateBingo() {
        List<Integer> bingoMatrix = new ArrayList<>(SIZE);
        for (int col = 0; col < WIDTH; col++) {
            List<Integer> array = new ArrayList<>();
            for (int i = 0; i < 15; i++) {
                int offset = col * 15;
                array.add(offset + i + 1);
            }
            Collections.shuffle(array);
            for (int row = 0; row < HEIGHT; row++) {
                bingoMatrix.add(array.get(row));
            }
        }
        bingoMatrix.set(12, 0);
        return bingoMatrix;
    }
}
