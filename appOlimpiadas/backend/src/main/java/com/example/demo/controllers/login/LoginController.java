package com.example.demo.controllers.login;

import com.example.demo.entitites.login.Login;
import com.example.demo.services.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("login")
    public ResponseEntity<Login> addPais(@RequestBody Login login) {
        boolean isLogged = loginService.login(login);

        if (isLogged) {
            return new ResponseEntity<>(login, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("logins")
    public ResponseEntity<List<Login>> getLogins() {
        List<Login> loggins = loginService.getAllLogins();

        return new ResponseEntity<>(loggins, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("register")
    public ResponseEntity<Login> registerUser(@RequestBody Login login) {
        boolean userCanBeRegister = loginService.register(login);

        if (userCanBeRegister) {
            return new ResponseEntity<>(login, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(login, HttpStatus.CONFLICT);
    }
}
