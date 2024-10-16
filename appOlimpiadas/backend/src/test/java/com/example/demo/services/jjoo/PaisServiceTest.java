package com.example.demo.services.jjoo;

import com.example.demo.entitites.jjoo.Pais;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(PaisService.class)
class PaisServiceTest {
    @Autowired
    private PaisService paisService;

    @Test
    void getAllPaises() {
        System.out.println(paisService.getAllPaises());
    }

    @Test
    void getPaisById() {
    }

    @Test
    void savePais() {
        Pais pais = new Pais();
        pais.setNombrePais("ESPAÑA");
        pais.setCodigoPais("ES");
        pais.setValorPais(100);

        Pais pais01 = paisService.savePais(pais);
        Pais pais02 = paisService.savePais(pais);

        // Id del primer país
        assertEquals(1, pais01.getId());

        // Id de insertar un país existente
        assertEquals(1, pais02.getId());

        pais.setNombrePais("FRANCIA");
        pais.setCodigoPais("FR");
        pais.setValorPais(1);
        Pais pais03 = paisService.savePais(pais);

        // Id del segundo país insertado
        assertEquals(2, pais03.getId());
    }

    @Test
    void findByCodigo() {
    }

    @Test
    void updatePais() {
    }

    @Test
    void getSedesQuery() {
    }
}