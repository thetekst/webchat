package ru.msk.tkachenko.dmitry.webchat.model;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 3/18/17
 */
public class MessageInfo {

    private String from;
    private String text;
    private String color;

    public MessageInfo() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
