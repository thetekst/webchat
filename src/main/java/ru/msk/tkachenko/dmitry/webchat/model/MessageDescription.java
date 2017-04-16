package ru.msk.tkachenko.dmitry.webchat.model;

import java.util.List;
import java.util.Set;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 3/18/17
 */
public class MessageDescription {

    private String from;
    private String text;
    private String time;
    private String color;
    private Set<User> users;


    public MessageDescription(final String from, final String text, final String time, String color, Set<User> users) {

        this.from = from;
        this.text = text;
        this.time = time;
        this.color = color;
        this.users = users;
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }

    public String getFrom() {
        return from;
    }

    public String getColor() {
        return color;
    }

    public Set<User> getUsers() {
        return users;
    }
}
