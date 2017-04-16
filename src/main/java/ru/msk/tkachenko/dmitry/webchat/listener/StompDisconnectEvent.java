package ru.msk.tkachenko.dmitry.webchat.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 4/16/17
 */
public class StompDisconnectEvent implements ApplicationListener<SessionDisconnectEvent> {

    @Override
    public void onApplicationEvent(SessionDisconnectEvent sessionDisconnectEvent) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(sessionDisconnectEvent.getMessage());

        System.out.println("STOMP Disconnect [sessionId: " + sha.getSessionId() + "] sha.toNativeHeaderMap():" + sha.toNativeHeaderMap());
    }
}
