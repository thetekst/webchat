package ru.msk.tkachenko.dmitry.webchat.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import ru.msk.tkachenko.dmitry.webchat.model.User;
import ru.msk.tkachenko.dmitry.webchat.model.Users;

import java.util.Map;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 4/16/17
 */
public class StompConnectEvent implements ApplicationListener<SessionConnectEvent> {

    @Autowired
    Users users;

    @Override
    public void onApplicationEvent(SessionConnectEvent sessionConnectEvent) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(sessionConnectEvent.getMessage());

        System.out.println("STOMP Connect [sessionId: " + sha.getSessionId() + "]");

        User user = new User();
        user.setId(sha.getSessionId());
        users.addUser(user);
        System.out.println("Conn size: " + users.getUsers().size());
    }
}
