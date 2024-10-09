package com.example.demo.services.jjoo;

public class ValidatePais {
    public static boolean nombrePais(String nombre) {
        return nombre.matches("^[A-Za-z ñÑáéíóúÁÉÍÓÚ]+$");
    }

    public static boolean codigoPais(String codigo) {
        return codigo.matches("^[A-Z]{2}$");
    }
}
