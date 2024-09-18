package com.example.demo.controllers;

import com.example.demo.entitites.Pais;
import com.example.demo.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaisController {
    @Autowired
    private PaisService paisService;

    @GetMapping("paises")
    public List<Pais> getPais() {
        return paisService.getAllPaises();
    }

    @GetMapping("paises/{id}")
    public Pais getPaisById(@PathVariable Long id) {
        return paisService.getPaisById(id);
    }

    @PostMapping("paises/add")
    public ResponseEntity<Pais> addPais(@RequestBody Pais pais) {
        Pais savedPais = paisService.savePais(pais);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedPais);
    }
}
