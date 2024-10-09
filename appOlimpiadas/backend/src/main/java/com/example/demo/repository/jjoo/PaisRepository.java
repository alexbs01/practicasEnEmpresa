package com.example.demo.repository.jjoo;

import com.example.demo.entitites.jjoo.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
    //@Query(value = "SELECT * FROM pais WHERE NOMBRE_PAIS = :nombre", nativeQuery = true)
    Pais findBynombrePais(String nombre);

    //@Query(value = "SELECT * FROM pais WHERE CODIGO_PAIS = :codigo", nativeQuery = true)
    Pais findBycodigoPais(String codigo);

    @Query(value = """
            SELECT p.ID_PAIS, p.NOMBRE_PAIS, c.ID_CIUDAD,
                    c.VALOR_CIUDAD, tj.DESCRIPCION_TIPO, COUNT(sj.SEDE)
            
            FROM pais AS p
                JOIN ciudad AS c ON p.ID_PAIS = c.ID_PAIS
                JOIN sede_jjoo AS sj ON sj.SEDE = c.ID_CIUDAD
                JOIN tipo_jjoo AS tj ON tj.ID_TIPO_JJOO = sj.ID_TIPO_JJOO
            
            GROUP BY p.ID_PAIS, p.NOMBRE_PAIS, c.ID_CIUDAD,
                    c.VALOR_CIUDAD, tj.DESCRIPCION_TIPO;
            """, nativeQuery = true)
    Optional<List<Object[]>> getNumeroSedesPorPais();
}
