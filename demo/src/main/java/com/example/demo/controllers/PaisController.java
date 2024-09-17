package com.example.demo.controllers;

import com.example.demo.entitites.Pais;
import com.example.demo.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
