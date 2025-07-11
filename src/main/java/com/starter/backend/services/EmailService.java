package com.starter.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    JavaMailSender mailSender;
    public void sendSimpleMessage(String to , String subject , String text){
       try {
           SimpleMailMessage message = new SimpleMailMessage();
           message.setFrom("mugishapascal2008@gmail.com");
           message.setTo(to);
           message.setSubject(subject);
           message.setText(text);
           mailSender.send(message);
       }catch (Exception e){
           System.out.println("error"+e);
           e.printStackTrace();
       }
    }
}

