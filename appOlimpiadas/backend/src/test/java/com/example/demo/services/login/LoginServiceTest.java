package com.example.demo.services.login;

import com.example.demo.entitites.login.Login;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureDataMongo
@Import(LoginService.class)
class LoginServiceTest {
    @Autowired
    private LoginService loginService;

    @Test
    void getAllLogins() {
        Login login = new Login("user", "pass");
        Login login2 = new Login("user2", "pass2");
        Login login3 = new Login("user3", "pass3");

        for(Login loginX : loginService.getAllLogins()) {
            System.out.println(loginX.getUsername());
        }

        loginService.register(login);
        loginService.register(login2);
        loginService.register(login3);

        System.out.println(loginService.getAllLogins());

        assertEquals(3, loginService.getAllLogins().size());
    }

    @Test
    void login() {
        Login login = new Login("user", "pass");

        loginService.register(login);
        assertTrue(loginService.login(login));

        login.setPassword("passIncorrect");
        assertFalse(loginService.login(login));
    }

    @Test
    void register() {
        Login login = new Login("user", "pass");

        assertTrue(loginService.register(login));
        assertFalse(loginService.register(login));
    }
}