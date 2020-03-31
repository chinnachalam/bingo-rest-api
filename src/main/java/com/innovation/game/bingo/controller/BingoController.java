package com.innovation.game.bingo.controller;

import com.innovation.game.bingo.model.Session;
import com.innovation.game.bingo.service.BingoService;
import com.innovation.game.bingo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bingo-rest/bingo/")
public class BingoController {

    @Autowired
    private BingoService bingoService;

    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public List<Integer> create(@RequestParam String sessionId) {
        Session session = sessionService.getSession(sessionId);
        if (session != null) {
            return bingoService.generateBingo(session.getUsername());
        } else {
            return null;
        }
    }

    @RequestMapping(value = "count", method = RequestMethod.GET)
    public Long count(@RequestParam String sessionId) {
        Session session = sessionService.getSession(sessionId);
        if (session != null) {
            return bingoService.getBingoCount(session.getUsername());
        } else {
            return null;
        }
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public List<List<Integer>> get(@RequestParam String sessionId) {
        Session session = sessionService.getSession(sessionId);
        if (session != null) {
            return bingoService.getAllBingos(session.getUsername());
        } else {
            return null;
        }
    }
}
