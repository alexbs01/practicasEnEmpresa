package com.example.demo.services;

import com.example.demo.entitites.Pais;
import com.example.demo.repository.PaisRepository;
import com.example.demo.repository.queries.NumeroSedesPorPaisDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaisService {
    @Autowired
    private PaisRepository repository;

    public List<Pais> getAllPaises(){
        return repository.findAll();
    }

    public Pais getPaisById(Long id){
        Optional<Pais> pais = repository.findById(id);

        return pais.orElse(null);
    }

    public Pais savePais(Pais pais){
        // If the country exists return the instance
        if(repository.findBynombrePais(pais.getNombrePais()) != null ||
                repository.findBycodigoPais(pais.getCodigoPais()) != null) {
            return repository.findBycodigoPais(pais.getCodigoPais());
        }

        // Set the new ID
        int newId = repository.findAll().getLast().getId() + 1;
        pais.setId(newId);

        return repository.save(pais);
    }

    public Pais findByCodigo(String codigo){
        return repository.findBycodigoPais(codigo);
    }

    public Pais updatePais(long id, Pais pais){

        if( ! Validate.nombrePais(pais.getNombrePais()) ||
            ! Validate.codigoPais(pais.getCodigoPais()) ||
                repository.findById(id).isEmpty()) {
            return null;
        }

        Pais paisToUpdate = repository.findById(id).get();

        paisToUpdate.setNombrePais(pais.getNombrePais());
        paisToUpdate.setCodigoPais(pais.getCodigoPais());
        paisToUpdate.setValorPais(pais.getValorPais());

        return repository.save(repository.findById(id).get());

    }

    public List<NumeroSedesPorPaisDTO> getSedesQuery() {
        Optional<List<Object[]>> result = repository.getNumeroSedesPorPais();

        return result.orElse(new ArrayList<>()).stream()
                .map(atrib -> new NumeroSedesPorPaisDTO(
                        ((Number) atrib[0]).longValue(),
                        (String) atrib[1],
                        ((Number) atrib[2]).longValue(),
                        ((Number) atrib[3]).longValue(),
                        (String) atrib[4],
                        ((Number) atrib[5]).longValue()
                )).collect(Collectors.toList());
    }
}
