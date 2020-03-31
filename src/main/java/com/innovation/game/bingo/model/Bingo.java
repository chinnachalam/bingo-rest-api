package com.innovation.game.bingo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Bingo {
    private String username;
    private List<Integer> bingoNumber;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Integer> getBingoNumber() {
        return bingoNumber;
    }

    public void setBingoNumber(List<Integer> bingoNumber) {
        this.bingoNumber = bingoNumber;
    }
}
