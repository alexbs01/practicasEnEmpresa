package com.example.demo.repository.queries;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NumeroSedesPorPaisDTO {

    @JsonProperty("ID_PAIS")
    private long ID_PAIS;

    @JsonProperty("NOMBRE_PAIS")
    private String NOMBRE_PAIS;

    @JsonProperty("ID_CIUDAD")
    private long ID_CIUDAD;

    @JsonProperty("VALOR_CIUDAD")
    private long VALOR_CIUDAD;

    @JsonProperty("DESCRIPCION_TIPO")
    private String DESCRIPCION_TIPO;

    @JsonProperty("COUNT_SEDES")
    private long COUNT_SEDES;

    public NumeroSedesPorPaisDTO(long idPais, String nombrePais,
                                 long idCiudad, long valorCiudad,
                                 String descripcionTipo, long countSedes) {
        this.ID_PAIS = idPais;
        this.NOMBRE_PAIS = nombrePais;
        this.ID_CIUDAD = idCiudad;
        this.VALOR_CIUDAD = valorCiudad;
        this.DESCRIPCION_TIPO = descripcionTipo;
        this.COUNT_SEDES = countSedes;
    }


}
