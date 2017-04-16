package ru.msk.tkachenko.dmitry.webchat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.msk.tkachenko.dmitry.webchat.listener.StompConnectEvent;
import ru.msk.tkachenko.dmitry.webchat.listener.StompDisconnectEvent;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 4/16/17
 */

@Configuration
public class WebSocketHandlersConfig {

    @Bean
    public StompConnectEvent webSocketConnectHandler() {
        return new StompConnectEvent();
    }

    @Bean
    public StompDisconnectEvent webSocketDisconnectHandler() {
        return new StompDisconnectEvent();
    }
}
