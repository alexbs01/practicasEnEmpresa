package com.example.demo.services;

public class Validate {
    public static boolean nombrePais(String nombre) {
        return nombre.matches("^[A-Za-z ]+$");
    }

    public static boolean codigoPais(String codigo) {
        return codigo.matches("^[A-Z]{2}$");
    }
}
