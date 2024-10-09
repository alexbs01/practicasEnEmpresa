package com.example.demo.repository.login;

import com.example.demo.entitites.login.Login;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface LoginRepository extends MongoRepository<Login, String> {
    Login findByusername(String username);
}
