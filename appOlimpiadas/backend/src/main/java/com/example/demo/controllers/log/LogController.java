package com.example.demo.controllers.log;

import com.example.demo.services.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    @Autowired
    private LogService logService;
    
    
}
