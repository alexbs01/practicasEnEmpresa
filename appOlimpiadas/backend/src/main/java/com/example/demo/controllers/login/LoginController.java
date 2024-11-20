package com.example.demo.controllers.login;

import com.example.demo.entitites.log.Log;
import com.example.demo.entitites.login.Login;
import com.example.demo.services.kafka.KafkaProducerService;
import com.example.demo.services.log.LogService;
import com.example.demo.services.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private LogService logService;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("login")
    public ResponseEntity<Login> logUser(@RequestBody Login login) {
        boolean isLogged = loginService.login(login);
        String action = isLogged ? "Login correct" : "Login incorrect";

        Log log = new Log(login.getUsername(), LocalDateTime.now(), action);
        try {
            logService.save(log);
            kafkaProducerService.logUserLogin(login.getUsername());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (isLogged) {
            return new ResponseEntity<>(login, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("logins")
    public ResponseEntity<List<Login>> getLogins() {
        List<Login> loggins = loginService.getAllLogins();

        return new ResponseEntity<>(loggins, HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<Login> registerUser(@RequestBody Login login) {
        boolean userCanBeRegister = loginService.register(login);
        String action = userCanBeRegister ? "Register correct" : "Register incorrect";

        Log log = new Log(login.getUsername(), LocalDateTime.now(), action);
        try {
            logService.save(log);
        } catch (InterruptedException e) {
                throw new RuntimeException(e);
        }

        if (userCanBeRegister) {
            return new ResponseEntity<>(login, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(login, HttpStatus.CONFLICT);
    }
}
