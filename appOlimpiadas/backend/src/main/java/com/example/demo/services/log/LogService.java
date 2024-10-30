package com.example.demo.services.log;

import com.example.demo.entitites.log.Log;
import com.example.demo.repository.log.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

@Service("logService")
public class LogService {

    private final LogRepository logRepository;
    private final TaskExecutor taskExecutor;

    @Autowired
    public LogService(LogRepository logRepository, @Qualifier("taskExecutor") TaskExecutor taskExecutor) {
        this.logRepository = logRepository;
        this.taskExecutor = taskExecutor;
    }

    public void save(Log log) throws InterruptedException {

        Runnable runnable = () -> logRepository.save(log);
        taskExecutor.execute(runnable);

    }

}
