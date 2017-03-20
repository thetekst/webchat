package ru.msk.tkachenko.dmitry.webchat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.msk.tkachenko.dmitry.webchat.model.MessageInfo;
import ru.msk.tkachenko.dmitry.webchat.model.MessageDescription;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 3/19/17
 */

@Controller
public class WebChatController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MessageDescription send(final MessageInfo message) throws Exception {

        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new MessageDescription(message.getFrom(), message.getText(), time);
    }
    @RequestMapping("/")
    public String start() {
        return "home";
    }
}
