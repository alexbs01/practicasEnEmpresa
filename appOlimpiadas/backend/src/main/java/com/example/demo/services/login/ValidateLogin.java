package com.example.demo.services.login;

public class ValidateLogin {
    public static boolean username(String name) {
        return name.matches("^[A-Za-z0-9._]+$");
    }
}
