package com.innovation.game.bingo.service;

import com.innovation.game.bingo.model.SingupResponse;
import com.innovation.game.bingo.model.User;
import com.innovation.game.bingo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public SingupResponse addUser(User user) {
        SingupResponse singupResponse = new SingupResponse();
        if (userRepository.findById(user.getUsername()).isPresent()) {
            singupResponse.setSuccessful(false);
            singupResponse.setMessage("user already exists");
        } else {
            userRepository.save(user);
            singupResponse.setSuccessful(true);
            singupResponse.setMessage("you have been registered successfully");
        }

        return singupResponse;
    }

    public User getUser(String userId) {
        if (userRepository.findById(userId).isPresent()) {
            return userRepository.findById(userId).get();
        } else {
            return null;
        }
    }
}
