package com.example.demo.services.jjoo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatePaisTest {

    @Test
    void nombrePais() {
        assertTrue(ValidatePais.nombrePais("ESPAÑA"));
        assertTrue(ValidatePais.nombrePais("españa"));
        assertTrue(ValidatePais.nombrePais("Estados Unidos"));
        assertTrue(ValidatePais.nombrePais("México"));

        assertFalse(ValidatePais.nombrePais(""));
        assertFalse(ValidatePais.nombrePais("ESPAÑA01"));
    }

    @Test
    void codigoPais() {
        assertTrue(ValidatePais.codigoPais("ES"));

        assertFalse(ValidatePais.codigoPais("es"));
        assertFalse(ValidatePais.codigoPais("E"));
        assertFalse(ValidatePais.codigoPais(""));
        assertFalse(ValidatePais.codigoPais("ESP"));
    }
}