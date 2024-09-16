package com.example.demo.model.entities;

import jakarta.persistence.*;

@Entity(name = "tipo_jjoo")
@Table(name = "tipo_jjoo")

public class TipoJJOO {
    @Id
    private int id;

    @Column(name = "DESCRIPCION_TIPO", length = 32, nullable = false)
    private String nombre;
}
