package com.example.demo.mapper;

import com.example.demo.entitites.jjoo.Pais;
import com.example.demo.mapper.dto.PaisDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaisMapper {
    PaisMapper INSTANCE = Mappers.getMapper(PaisMapper.class);

    Pais toPais(PaisDTO paisDTO);

    @Mapping(target = "idPais", source = "id")
    PaisDTO toPaisDTO(Pais pais);

    @Mapping(target = "ID_PAIS", source = "idPais")
    @Mapping(target = "NOMBRE_PAIS", source = "nombrePais")
    @Mapping(target = "CODIGO_PAIS", source = "codigoPais")
    @Mapping(target = "VALOR_PAIS", source = "valorPais")
    io.reflectoring.model.Pais toReflectoringPais(PaisDTO paisDTO);
}
