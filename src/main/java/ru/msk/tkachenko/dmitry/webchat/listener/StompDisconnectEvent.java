package ru.msk.tkachenko.dmitry.webchat.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import ru.msk.tkachenko.dmitry.webchat.controller.WebChatController;
import ru.msk.tkachenko.dmitry.webchat.model.MessageInfo;
import ru.msk.tkachenko.dmitry.webchat.model.Users;

import java.util.Map;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 4/16/17
 */
public class StompDisconnectEvent implements ApplicationListener<SessionDisconnectEvent> {

    @Autowired
    Users users;

    @Override
    public void onApplicationEvent(SessionDisconnectEvent sessionDisconnectEvent) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(sessionDisconnectEvent.getMessage());

        System.out.println("STOMP Disconnect [sessionId: " + sha.getSessionId() + "]");
        users.removeUser(sha.getSessionId());
        System.out.println("Disc size: " + users.getUsers().size());
    }
}
