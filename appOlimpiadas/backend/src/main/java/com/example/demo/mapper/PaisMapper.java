package com.example.demo.mapper;

import com.example.demo.entitites.jjoo.Pais;
import com.example.demo.mapper.dto.PaisDTO;
import com.example.demo.mapper.dto.SedesDTO;
import com.example.demo.repository.jjoo.queries.NumeroSedesPorPais;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaisMapper {
    PaisMapper INSTANCE = Mappers.getMapper(PaisMapper.class);

    @Mapping(target = "id", source = "idPais")
    Pais toPais(PaisDTO paisDTO);

    @Mapping(target = "idPais", source = "id")
    PaisDTO toPaisDTO(Pais pais);

    @Mapping(target = "ID_PAIS", source = "idPais")
    @Mapping(target = "NOMBRE_PAIS", source = "nombrePais")
    @Mapping(target = "CODIGO_PAIS", source = "codigoPais")
    @Mapping(target = "VALOR_PAIS", source = "valorPais")
    io.reflectoring.model.Pais toReflectoringPais(PaisDTO paisDTO);

    @Mapping(target = "ID_PAIS", source = "idPais")
    @Mapping(target = "NOMBRE_PAIS", source = "nombrePais")
    @Mapping(target = "ID_CIUDAD", source = "idCiudad")
    @Mapping(target = "VALOR_CIUDAD", source = "valorCiudad")
    @Mapping(target = "DESCRIPCION_TIPO", source = "descripcionTipo")
    @Mapping(target = "COUNT_SEDES", source = "countSedes")
    io.reflectoring.model.SedesInner toSedesInner(SedesDTO sedesDTO);

    @Mapping(target = "idPais", source = "ID_PAIS")
    @Mapping(target = "nombrePais", source = "NOMBRE_PAIS")
    @Mapping(target = "idCiudad", source = "ID_CIUDAD")
    @Mapping(target = "valorCiudad", source = "VALOR_CIUDAD")
    @Mapping(target = "descripcionTipo", source = "DESCRIPCION_TIPO")
    @Mapping(target = "countSedes", source = "COUNT_SEDES")
    SedesDTO toSedesDTO(NumeroSedesPorPais numeroSedesPorPais);

    default NumeroSedesPorPais toNumeroSedesPorPais(Object[] values) {
        if (values == null || values.length < 6) {
            return null;
        }

        Integer idPais = ((Number) values[0]).intValue();
        String nombrePais = ((String) values[1]).trim();
        Integer idCiudad = ((Number) values[2]).intValue();
        Integer valorCiudad = ((Number) values[3]).intValue();
        String descripcionTipo = ((String) values[4]).trim();
        Integer countSedes = ((Number) values[5]).intValue();

        return new NumeroSedesPorPais(idPais, nombrePais, idCiudad, valorCiudad, descripcionTipo, countSedes);
    }
}
