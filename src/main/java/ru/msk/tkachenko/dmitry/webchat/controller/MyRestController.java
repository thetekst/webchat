package ru.msk.tkachenko.dmitry.webchat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.msk.tkachenko.dmitry.webchat.model.User;
import ru.msk.tkachenko.dmitry.webchat.model.Users;

import java.util.Set;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 4/16/17
 */

@RestController
public class MyRestController {

    @Autowired
    Users users;

    @RequestMapping(value = "/getuserlist", method = RequestMethod.GET, produces = "application/json")
    public Set<User> getUsers() {
        return users.getUsers();
    }
}
