package com.innovation.game.bingo.service;

import com.innovation.game.bingo.model.Session;
import com.innovation.game.bingo.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public Session createSession(String username) {
        Session session = new Session();
        session.setUsername(username);
        session.setSessionId(UUID.randomUUID().toString());
        return sessionRepository.save(session);
    }

    public Session getSession(String sessionId) {
        Optional<Session> session = sessionRepository.findById(sessionId);
        if (session.isPresent()) {
            return session.get();
        } else {
            return null;
        }
    }
}
