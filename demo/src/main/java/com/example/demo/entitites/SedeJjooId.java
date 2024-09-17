package com.example.demo.entitites;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class SedeJjooId implements java.io.Serializable {
    private static final long serialVersionUID = 8821688124063642635L;
    @Column(name = "`AÑO`", nullable = false)
    private Integer ano;

    @Column(name = "ID_TIPO_JJOO", nullable = false)
    private Integer idTipoJjoo;

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getIdTipoJjoo() {
        return idTipoJjoo;
    }

    public void setIdTipoJjoo(Integer idTipoJjoo) {
        this.idTipoJjoo = idTipoJjoo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SedeJjooId entity = (SedeJjooId) o;
        return Objects.equals(this.idTipoJjoo, entity.idTipoJjoo) &&
                Objects.equals(this.ano, entity.ano);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTipoJjoo, ano);
    }

}