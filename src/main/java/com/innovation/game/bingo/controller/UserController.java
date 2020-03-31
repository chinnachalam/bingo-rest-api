package com.innovation.game.bingo.controller;

import com.innovation.game.bingo.model.LoginResponse;
import com.innovation.game.bingo.model.Session;
import com.innovation.game.bingo.model.SingupResponse;
import com.innovation.game.bingo.model.User;
import com.innovation.game.bingo.service.SessionService;
import com.innovation.game.bingo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bingo-rest/user/")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public LoginResponse login(@RequestBody User user) {
        User findUser = userService.getUser(user.getUsername());
        LoginResponse loginResponse = new LoginResponse();
        if (findUser != null && findUser.getPassword().equals(user.getPassword())) {
            Session session = sessionService.createSession(user.getUsername());
            loginResponse.setUsername(user.getUsername());
            loginResponse.setLoginSuccess(true);
            loginResponse.setSessionId(session.getSessionId());
        } else {
            loginResponse.setLoginSuccess(false);
        }

        return loginResponse;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public SingupResponse register(@RequestBody User user) {
        return userService.addUser(user);
    }
}
