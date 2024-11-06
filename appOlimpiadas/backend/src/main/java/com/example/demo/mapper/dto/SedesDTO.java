package com.example.demo.mapper.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SedesDTO {
    private Integer idPais;
    private String nombrePais;
    private Integer idCiudad;
    private Integer valorCiudad;
    private String descripcionTipo;
    private Integer countSedes;

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Integer getValorCiudad() {
        return valorCiudad;
    }

    public void setValorCiudad(Integer valorCiudad) {
        this.valorCiudad = valorCiudad;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }

    public Integer getCountSedes() {
        return countSedes;
    }

    public void setCountSedes(Integer countSedes) {
        this.countSedes = countSedes;
    }
}
