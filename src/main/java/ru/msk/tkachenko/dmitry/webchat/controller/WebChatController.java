package ru.msk.tkachenko.dmitry.webchat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.msk.tkachenko.dmitry.webchat.model.MessageInfo;
import ru.msk.tkachenko.dmitry.webchat.model.MessageDescription;
import ru.msk.tkachenko.dmitry.webchat.model.User;
import ru.msk.tkachenko.dmitry.webchat.model.Users;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 3/19/17
 */

@Controller
public class WebChatController {

    @Autowired
    Users users;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MessageDescription send(final MessageInfo message) throws Exception {

        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new MessageDescription(message.getFrom(), message.getText(), time, message.getColor(), users.getUsers());
    }

    @RequestMapping("/")
    public String start() {
        return "home";
    }
}
