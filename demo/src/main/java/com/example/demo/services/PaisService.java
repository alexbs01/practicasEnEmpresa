package com.example.demo.services;

import com.example.demo.entitites.Pais;
import com.example.demo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PaisService {
    @Autowired
    private PaisRepository repository;

    public List<Pais> getAllPaises(){
        return repository.findAll();
    }

    public Pais getPaisById(Long id){
        if(repository.findById(id).isPresent()){
            return repository.findById(id).get();
        }

        return null;
    }

    public Pais savePais(Pais pais){
        // If the country exists return the instance
        if(repository.findByNombre(pais.getNombrePais()).isPresent() ||
                repository.findByCodigo(pais.getCodigoPais()).isPresent()) {
            return repository.findByCodigo(pais.getCodigoPais()).get();
        }

        // Set the new ID
        int newId = repository.findAll().getLast().getId() + 1;
        pais.setId(newId);

        return repository.save(pais);
    }

    public Pais findByCodigo(String codigo){
        Optional<Pais> pais = repository.findByCodigo(codigo);

        return pais.orElse(null);
    }

    public Pais updatePais(long id, Pais pais){
        if(repository.findById(id).isPresent()) {
            repository.findById(id).get().setNombrePais(pais.getNombrePais());
            repository.findById(id).get().setCodigoPais(pais.getCodigoPais());
            repository.findById(id).get().setValorPais(pais.getValorPais());

            return repository.save(repository.save(repository.findById(id).get()));
        }

        return null;
    }
}
