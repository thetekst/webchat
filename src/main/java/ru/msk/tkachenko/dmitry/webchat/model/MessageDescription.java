package ru.msk.tkachenko.dmitry.webchat.model;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 3/18/17
 */
public class MessageDescription {

    private String from;
    private String text;
    private String time;

    public MessageDescription(final String from, final String text, final String time) {

        this.from = from;
        this.text = text;
        this.time = time;
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
}
