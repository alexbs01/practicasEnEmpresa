package com.example.demo.services.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "user-login";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void logUserLogin(String username) {
        Map<String, String> loginEvent = new HashMap<>();
        loginEvent.put("username", username);
        loginEvent.put("timestamp", LocalDateTime.now().toString());

        String message = loginEvent.toString();

        kafkaTemplate.send(TOPIC, username, message);
        System.out.printf("Login registrado: %s%n", message);
    }
}

