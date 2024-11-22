package com.example.demo.components;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserLoginConsumer {

    @KafkaListener(topics = "user-login", groupId = "user-login-group")
    public void consumeMessage(String message) {
        System.out.println("Mensaje recibido del topic 'user-login': " + message);
    }
}