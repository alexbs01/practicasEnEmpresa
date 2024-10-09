package com.example.demo.services.login;

public class ValidateLogin {
    public static boolean username(String nombre) {
        return nombre.matches("^[A-Za-z0-9]+$");
    }
}
