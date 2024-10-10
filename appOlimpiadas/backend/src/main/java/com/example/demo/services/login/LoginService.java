package com.example.demo.services.login;

import com.example.demo.entitites.login.Login;
import com.example.demo.repository.login.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("loginService")
public class LoginService {
    @Autowired
    private LoginRepository repository;

    public List<Login> getAllLogins() {
        return repository.findAll();
    }

    public boolean login(Login login) {
        String username = login.getUsername().toLowerCase();
        String password = login.getPassword();

        return repository.findByusername(username).getPassword().equals(password);
    }

    public boolean register(Login login) {
        String username = login.getUsername().toLowerCase();

        if(repository.findByusername(username) == null && ValidateLogin.username(username)){
            login.setUsername(username);
            repository.save(login);
            return true;
        }

        return false;
    }
}
