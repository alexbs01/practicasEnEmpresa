package com.example.demo.entitites;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "pais")
public class Pais {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAIS")
    private Integer id;

    @JsonProperty("NOMBRE_PAIS")
    @Column(name = "NOMBRE_PAIS", nullable = false, length = 64, unique = true)
    private String nombrePais;

    @JsonProperty("CODIGO_PAIS")
    @Column(name = "CODIGO_PAIS", nullable = false, length = 2, unique = true)
    private String codigoPais;

    @JsonProperty("VALOR_PAIS")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return Objects.equals(nombrePais, pais.nombrePais) && Objects.equals(codigoPais, pais.codigoPais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombrePais, codigoPais);
    }


}