package com.example.demo.repository.jjoo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class PaisRepositoryQueryDSL implements PaisRepository {
    @PersistenceContext
    private EntityManager entityManager;

    /*@Override
    public List<Object[]> getNumeroSedesPorPais() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);

        QPais pais = QPais.pais;
        QCiudad ciudad = QCiudad.ciudad;
        QSedeJjoo sedeJjoo = QSedeJjoo.sedeJjoo;
        QTipoJjoo tipoJjoo = QTipoJjoo.tipoJjoo;

        return queryFactory.select(pais.idPais, pais.nombrePais, ciudad.idCiudad,
                        ciudad.valorCiudad, tipoJjoo.descripcionTipo, sedeJjoo.sede.count())
                .from(pais)
                .join(ciudad).on(pais.idPais.eq(ciudad.pais.idPais))
                .join(sedeJjoo).on(sedeJjoo.sede.eq(ciudad.idCiudad))
                .join(tipoJjoo).on(tipoJjoo.idTipoJjoo.eq(sedeJjoo.tipoJjoo.idTipoJjoo))
                .groupBy(pais.idPais, pais.nombrePais, ciudad.idCiudad,
                        ciudad.valorCiudad, tipoJjoo.descripcionTipo)
                .fetch();
    }*/
}
