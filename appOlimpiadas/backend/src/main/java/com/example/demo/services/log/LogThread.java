package com.example.demo.services.log;

import com.example.demo.entitites.log.Log;

public class LogThread implements Runnable {
    private final LogService logService;
    private final Log log;

    public LogThread(LogService logService, Log log) {
        this.logService = logService;
        this.log = log;
    }

    @Override
    public void run() {
        logService.save(log);
    }
}
