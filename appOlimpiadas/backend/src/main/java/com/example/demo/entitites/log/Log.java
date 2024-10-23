package com.example.demo.entitites.log;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("log")
public class Log {
    private String userId;
    private LocalDateTime dateTime;
    private String action;

    public Log(String userId, LocalDateTime dateTime, String action) {
        this.userId = userId;
        this.dateTime = dateTime;
        this.action = action;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getTimestamp() {
        return dateTime;
    }

    public void setTimestamp(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
