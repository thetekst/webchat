package ru.msk.tkachenko.dmitry.webchat.model;

import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 4/16/17
 */

//@Scope("singleton")
public class Users {

    private Set<User> users;

    public Users() {
        this.users = new HashSet<>();
    }

    public Set<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        System.out.println(user.toString());
        users.add(user);
    }

    public void removeUser(String id) {

        for (User user : users) {
            if (user.getId().equals(id)) {
                System.out.println(user.toString());
                users.remove(user);
            }
        }
    }
}
