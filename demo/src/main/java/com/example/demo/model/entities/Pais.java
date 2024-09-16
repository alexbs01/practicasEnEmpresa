package com.example.demo.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "pais")
@Table(name = "pais")

public class Pais {
    @Id
    private int id;

    @Column(name = "NOMBRE_PAIS", length = 64, nullable = false)
    private String name;

    @Column(name = "CODIGO_PAIS", length = 2, nullable = false)
    private String code;

    @Column(name = "VALOR_PAIS")
    private int value;
}
