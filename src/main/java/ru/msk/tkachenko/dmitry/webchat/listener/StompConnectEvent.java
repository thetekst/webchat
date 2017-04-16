package ru.msk.tkachenko.dmitry.webchat.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionConnectEvent;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 4/16/17
 */
public class StompConnectEvent implements ApplicationListener<SessionConnectEvent> {

    @Override
    public void onApplicationEvent(SessionConnectEvent sessionConnectEvent) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(sessionConnectEvent.getMessage());

        System.out.println("STOMP Connect [sessionId: " + sha.getSessionId() + "] sha.toNativeHeaderMap():" + sha.toNativeHeaderMap());
    }
}
