package com.example.demo.repository.jjoo.queries;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NumeroSedesPorPaisDTO {

    @JsonProperty("ID_PAIS")
    private Integer ID_PAIS;

    @JsonProperty("NOMBRE_PAIS")
    private String NOMBRE_PAIS;

    @JsonProperty("ID_CIUDAD")
    private Integer ID_CIUDAD;

    @JsonProperty("VALOR_CIUDAD")
    private Integer VALOR_CIUDAD;

    @JsonProperty("DESCRIPCION_TIPO")
    private String DESCRIPCION_TIPO;

    @JsonProperty("COUNT_SEDES")
    private Integer COUNT_SEDES;

    public NumeroSedesPorPaisDTO(Integer idPais, String nombrePais,
                                 Integer idCiudad, Integer valorCiudad,
                                 String descripcionTipo, Integer countSedes) {
        this.ID_PAIS = idPais;
        this.NOMBRE_PAIS = nombrePais;
        this.ID_CIUDAD = idCiudad;
        this.VALOR_CIUDAD = valorCiudad;
        this.DESCRIPCION_TIPO = descripcionTipo;
        this.COUNT_SEDES = countSedes;
    }

    public Integer getID_PAIS() {
        return ID_PAIS;
    }

    public void setID_PAIS(Integer ID_PAIS) {
        this.ID_PAIS = ID_PAIS;
    }

    public String getNOMBRE_PAIS() {
        return NOMBRE_PAIS;
    }

    public void setNOMBRE_PAIS(String NOMBRE_PAIS) {
        this.NOMBRE_PAIS = NOMBRE_PAIS;
    }

    public Integer getID_CIUDAD() {
        return ID_CIUDAD;
    }

    public void setID_CIUDAD(Integer ID_CIUDAD) {
        this.ID_CIUDAD = ID_CIUDAD;
    }

    public Integer getVALOR_CIUDAD() {
        return VALOR_CIUDAD;
    }

    public void setVALOR_CIUDAD(Integer VALOR_CIUDAD) {
        this.VALOR_CIUDAD = VALOR_CIUDAD;
    }

    public String getDESCRIPCION_TIPO() {
        return DESCRIPCION_TIPO;
    }

    public void setDESCRIPCION_TIPO(String DESCRIPCION_TIPO) {
        this.DESCRIPCION_TIPO = DESCRIPCION_TIPO;
    }

    public Integer getCOUNT_SEDES() {
        return COUNT_SEDES;
    }

    public void setCOUNT_SEDES(Integer COUNT_SEDES) {
        this.COUNT_SEDES = COUNT_SEDES;
    }
}
