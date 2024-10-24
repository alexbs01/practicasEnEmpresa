package com.example.demo.services.log;

import com.example.demo.entitites.log.Log;
import com.example.demo.repository.log.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("logService")
public class LogService {
    @Autowired
    private LogRepository logRepository;

    public void save(Log log) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                logRepository.save(log);
            }
        }).start();
    }
}
