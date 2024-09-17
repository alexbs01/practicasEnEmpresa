package com.example.demo.services;

import com.example.demo.entitites.Pais;
import com.example.demo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {
    @Autowired
    private PaisRepository repository;

    public List<Pais> getAllPaises(){
        return repository.findAll();
    }

    public Pais getPaisById(Long id){
        return repository.findById(id).get();
    }
}
