package com.example.demo.services.jjoo;

import com.example.demo.entitites.jjoo.Pais;
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
        Pais pais = new Pais();

        pais.setNombrePais("ESPAÑA");
        pais.setCodigoPais("ES");
        pais.setValorPais(100);
        paisService.savePais(pais);

        pais.setNombrePais("FRANCIA");
        pais.setCodigoPais("FR");
        pais.setValorPais(1);
        paisService.savePais(pais);

        pais.setNombrePais("GRECIA");
        pais.setCodigoPais("GR");
        pais.setValorPais(50);
        paisService.savePais(pais);

        assertEquals(3, paisService.getAllPaises().size());
    }

    @Test
    void getPaisById() {
        Pais pais = new Pais();

        pais.setNombrePais("ESPAÑA");
        pais.setCodigoPais("ES");
        pais.setValorPais(100);
        Pais pais01 = paisService.savePais(pais);

        pais.setNombrePais("FRANCIA");
        pais.setCodigoPais("FR");
        pais.setValorPais(1);
        Pais pais02 = paisService.savePais(pais);

        pais.setNombrePais("GRECIA");
        pais.setCodigoPais("GR");
        pais.setValorPais(50);
        Pais pais03 = paisService.savePais(pais);

        assertEquals(pais01.getNombrePais(), paisService.getPaisById(1L).getNombrePais());
        assertEquals(pais02.getCodigoPais(), paisService.getPaisById(2L).getCodigoPais());
        assertEquals(pais03.getCodigoPais(), paisService.getPaisById(3L).getCodigoPais());
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
        Pais pais = new Pais();

        pais.setNombrePais("ESPAÑA");
        pais.setCodigoPais("ES");
        pais.setValorPais(100);
        Pais pais01 = paisService.savePais(pais);

        pais.setNombrePais("FRANCIA");
        pais.setCodigoPais("FR");
        pais.setValorPais(1);
        Pais pais02 = paisService.savePais(pais);

        pais.setNombrePais("GRECIA");
        pais.setCodigoPais("GR");
        pais.setValorPais(50);
        Pais pais03 = paisService.savePais(pais);

        assertEquals(pais01.getNombrePais(), paisService.findByCodigo("ES").getNombrePais());
        assertEquals(pais02.getCodigoPais(), paisService.findByCodigo("FR").getCodigoPais());
        assertEquals(pais03.getCodigoPais(), paisService.findByCodigo("GR").getCodigoPais());
    }

    @Test
    void updatePais() {
        Pais pais = new Pais();

        pais.setNombrePais("ESPAÑA");
        pais.setCodigoPais("ES");
        pais.setValorPais(100);
        paisService.savePais(pais);

        pais.setNombrePais("FRANCIA");
        pais.setCodigoPais("FR");
        pais.setValorPais(1);
        paisService.savePais(pais);

        pais.setNombrePais("GRECIA");
        pais.setCodigoPais("GR");
        pais.setValorPais(50);
        Pais pais03 = paisService.savePais(pais);

        Pais newPais01 = paisService.findByCodigo("ES");
        newPais01.setNombrePais("PORTUGAL");
        newPais01.setCodigoPais("PR");

        Pais newPais02 = paisService.findByCodigo("FR");
        newPais02.setValorPais(-200);

        assertEquals("PORTUGAL", paisService.updatePais(1L, newPais01).getNombrePais());
        assertEquals(-200, paisService.updatePais(2L, newPais02).getValorPais());
    }

    @Test
    void getSedesQuery() {

    }
}