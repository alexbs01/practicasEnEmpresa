package com.example.demo.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pais")
public class Pais {
    @Id
    @Column(name = "ID_PAIS", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE_PAIS", nullable = false, length = 64)
    private String nombrePais;

    @Column(name = "CODIGO_PAIS", nullable = false, length = 2)
    private String codigoPais;

    @Column(name = "VALOR_PAIS", nullable = false)
    private Integer valorPais;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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