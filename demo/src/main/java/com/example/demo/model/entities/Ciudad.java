package com.example.demo.model.entities;

import jakarta.persistence.*;

@Entity(name = "ciudad")
@Table(name = "ciudad")

public class Ciudad {
    @Id
    private int id;

    @Column(name = "NOMBRE_CIUDAD", length = 64, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PAIS", nullable = false)
    private Pais idCountry;

    @Column(name = "VALOR_CIUDAD", nullable = true)
    private int valueCity;
}
