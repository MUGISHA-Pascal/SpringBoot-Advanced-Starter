package com.starter.backend.controllers;

import com.starter.backend.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final SimpMessagingTemplate template;
    public ChatController(SimpMessagingTemplate template) {
        this.template = template;
    }
    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public Message sendMessage(Message message){
        return message;
    }
}
