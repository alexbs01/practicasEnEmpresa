package com.example.demo.entitites;

import jakarta.persistence.*;

@Entity
@Table(name = "ciudad")
public class Ciudad {
    @Id
    @Column(name = "ID_CIUDAD", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE_CIUDAD", nullable = false, length = 64)
    private String nombreCiudad;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_PAIS", nullable = false)
    private Pais idPais;

    @Column(name = "VALOR_CIUDAD")
    private Integer valorCiudad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public Pais getIdPais() {
        return idPais;
    }

    public void setIdPais(Pais idPais) {
        this.idPais = idPais;
    }

    public Integer getValorCiudad() {
        return valorCiudad;
    }

    public void setValorCiudad(Integer valorCiudad) {
        this.valorCiudad = valorCiudad;
    }

}