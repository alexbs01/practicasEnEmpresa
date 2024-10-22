package com.example.demo.controllers.login;

import com.example.demo.entitites.log.Log;
import com.example.demo.entitites.login.Login;
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

    @CrossOrigin(origins = "https://localhost:5173")
    @PostMapping("login")
    public ResponseEntity<Login> logUser(@RequestBody Login login) {
        boolean isLogged = loginService.login(login);

        if (isLogged) {
            logService.save(new Log(login.getUsername(), LocalDateTime.now(), "Login correct"));
            return new ResponseEntity<>(login, HttpStatus.OK);
        }

        logService.save(new Log(login.getUsername(), LocalDateTime.now(), "Login incorrect"));
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @CrossOrigin(origins = "https://localhost:5173")
    @GetMapping("logins")
    public ResponseEntity<List<Login>> getLogins() {
        List<Login> loggins = loginService.getAllLogins();

        return new ResponseEntity<>(loggins, HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://localhost:5173")
    @PostMapping("register")
    public ResponseEntity<Login> registerUser(@RequestBody Login login) {
        boolean userCanBeRegister = loginService.register(login);

        if (userCanBeRegister) {
            logService.save(new Log(login.getUsername(), LocalDateTime.now(), "Register correct"));
            return new ResponseEntity<>(login, HttpStatus.CREATED);
        }

        logService.save(new Log(login.getUsername(), LocalDateTime.now(), "Register incorrect"));
        return new ResponseEntity<>(login, HttpStatus.CONFLICT);
    }
}
