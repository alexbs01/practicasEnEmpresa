package com.example.demo.model.entities;

import com.example.demo.model.entities.Ciudad;
import com.example.demo.model.entities.SedeJjooId;
import com.example.demo.model.entities.TipoJjoo;
import jakarta.persistence.*;

@Entity
@Table(name = "sede_jjoo")
public class SedeJjoo {
    @EmbeddedId
    private SedeJjooId id;

    @MapsId("idTipoJjoo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_TIPO_JJOO", nullable = false)
    private TipoJjoo idTipoJjoo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SEDE", nullable = false)
    private Ciudad sede;

    public SedeJjooId getId() {
        return id;
    }

    public void setId(SedeJjooId id) {
        this.id = id;
    }

    public TipoJjoo getIdTipoJjoo() {
        return idTipoJjoo;
    }

    public void setIdTipoJjoo(TipoJjoo idTipoJjoo) {
        this.idTipoJjoo = idTipoJjoo;
    }

    public Ciudad getSede() {
        return sede;
    }

    public void setSede(Ciudad sede) {
        this.sede = sede;
    }

}