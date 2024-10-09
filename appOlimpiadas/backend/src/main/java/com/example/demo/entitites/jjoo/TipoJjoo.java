package com.example.demo.entitites.jjoo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_jjoo")
public class TipoJjoo {
    @Id
    @Column(name = "ID_TIPO_JJOO", nullable = false)
    private Integer id;

    @Column(name = "DESCRIPCION_TIPO", nullable = false, length = 32)
    private String descripcionTipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }

}