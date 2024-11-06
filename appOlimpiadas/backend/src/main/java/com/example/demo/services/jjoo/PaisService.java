package com.example.demo.services.jjoo;

import com.example.demo.entitites.jjoo.Pais;
import com.example.demo.mapper.PaisMapper;
import com.example.demo.mapper.dto.PaisDTO;
import com.example.demo.mapper.dto.SedesDTO;
import com.example.demo.repository.jjoo.PaisRepository;
import com.example.demo.repository.jjoo.queries.NumeroSedesPorPais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("paisServiceJJOO")
public class PaisService {
    @Autowired
    private PaisRepository repository;

    @Autowired
    private PaisMapper paisMapper;

    public List<PaisDTO> getAllPaises(){
        List<Pais> paises = repository.findAll();

        return paises.stream().map(paisMapper::toPaisDTO).toList();
    }

    public PaisDTO getPaisById(Long id){
        Optional<Pais> pais = repository.findById(id);

        return pais.map(value -> paisMapper.toPaisDTO(value)).orElse(null);
    }

    public PaisDTO savePais(Pais pais) {
        // Si el país ya existe, devolvemos la instancia existente
        if (repository.findBynombrePais(pais.getNombrePais()) != null ||
                repository.findBycodigoPais(pais.getCodigoPais()) != null) {

            Pais existPais = repository.findBynombrePais(pais.getNombrePais());
            return paisMapper.toPaisDTO(existPais);
        }

        List<Pais> paises = repository.findAll();

        int newId;

        if (!paises.isEmpty()) {
            newId = paises.getLast().getId() + 1;
        } else {
            // Si no hay países se inserta el primero
            newId = 1;
        }

        pais.setId(newId);

        Pais paisToSave = repository.save(pais);

        return paisMapper.toPaisDTO(paisToSave);
    }


    public PaisDTO findByCodigo(String codigo){
        Pais pais = repository.findBycodigoPais(codigo);
        return paisMapper.toPaisDTO(pais);
    }

    public PaisDTO updatePais(long id, Pais pais){

        if( ! ValidatePais.nombrePais(pais.getNombrePais()) ||
            ! ValidatePais.codigoPais(pais.getCodigoPais()) ||
                repository.findById(id).isEmpty()) {
            
            return null;
        }

        Pais paisToUpdate = repository.findById(id).get();

        paisToUpdate.setNombrePais(pais.getNombrePais());
        paisToUpdate.setCodigoPais(pais.getCodigoPais());
        paisToUpdate.setValorPais(pais.getValorPais());

        Pais paisToSave = repository.save(paisToUpdate);

        return paisMapper.toPaisDTO(paisToSave);

    }

    public List<SedesDTO> getSedesQuery() {
        Optional<List<Object[]>> result = repository.getNumeroSedesPorPais();

        List<NumeroSedesPorPais> sedes = result.orElse(new ArrayList<>()).stream()
                .map(paisMapper::toNumeroSedesPorPais)
                .toList();

        return sedes.stream().map(paisMapper::toSedesDTO).toList();
    }
}
