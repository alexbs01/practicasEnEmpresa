package com.example.demo.mapper.dto;

public class PaisDTO {
    private Integer idPais;
    private String nombrePais;
    private String codigoPais;
    private Integer valorPais;

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

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public Integer getValorPais() {
        return valorPais;
    }

    public void setValorPais(Integer valorPais) {
        this.valorPais = valorPais;
    }
}
