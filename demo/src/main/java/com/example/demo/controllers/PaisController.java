package com.example.demo.controllers;

import com.example.demo.entitites.Pais;
import com.example.demo.repository.queries.NumeroSedesPorPaisDTO;
import com.example.demo.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class PaisController {
    @Autowired
    private PaisService paisService;

    @GetMapping("paises")
    public ResponseEntity<List<Pais>> getPais() {
        List<Pais> paises = paisService.getAllPaises();
        return ResponseEntity.status(HttpStatus.OK).body(paises);
    }

    @GetMapping("paises/{id}")
    public ResponseEntity<Pais> getPaisById(@PathVariable Long id) {
        Pais pais = paisService.getPaisById(id);

        if(pais != null) {
            return ResponseEntity.status(HttpStatus.OK).body(pais);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("paises/add")
    public ResponseEntity<Pais> addPais(@RequestBody Pais pais) {
        Pais savedPais = paisService.savePais(pais);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPais);
    }

    @GetMapping("paises/codigo/{codigo}")
    public ResponseEntity<Pais> getPaisByCodigo(@PathVariable String codigo) {
        Pais pais = paisService.findByCodigo(codigo);

        if (pais != null) {
            return ResponseEntity.status(HttpStatus.OK).body(pais);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("paises/update/{id}")
    public ResponseEntity<Pais> updatePais(@PathVariable long id, @RequestBody Pais pais) {
        Pais savedPais = paisService.updatePais(id, pais);
        if (savedPais != null) {
            return ResponseEntity.status(HttpStatus.OK).body(savedPais);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @GetMapping("sedes")
    public ResponseEntity<List<NumeroSedesPorPaisDTO>> getSedes() {
        List<NumeroSedesPorPaisDTO> paises = paisService.getSedesQuery();
        System.out.println("AAAAAA");
        System.out.println(paises.get(1));
        System.out.println("BBBBBB");
        return ResponseEntity.status(HttpStatus.OK).body(paises);
    }
}
