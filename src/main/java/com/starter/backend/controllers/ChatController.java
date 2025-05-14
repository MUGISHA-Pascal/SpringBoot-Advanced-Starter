package com.starter.backend.controllers;

import com.starter.backend.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
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
    @MessageMapping("/private-message")
    public void sendPrivateMessage(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) {
        // Access the current user's identity (username)
        String sender = (String) headerAccessor.getSessionAttributes().get("username");
        message.setSender(sender);  // Set the sender to the current authenticated user

        // Send the private message to the recipient
//        template.convertAndSendToUser(
//                message.getRecipient(),  // recipient username
//                "/queue/messages",       // destination queue
//                message                  // message payload
//        );
    }

}
