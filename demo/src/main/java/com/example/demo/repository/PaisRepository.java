package com.example.demo.repository;

import com.example.demo.entitites.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
    @Query(value = "SELECT * FROM pais WHERE NOMBRE_PAIS = :nombre", nativeQuery = true)
    Optional<Pais> findByNombre(@Param("nombre") String nombre);

    @Query(value = "SELECT * FROM pais WHERE CODIGO_PAIS = :codigo", nativeQuery = true)
    Optional<Pais> findByCodigo(@Param("codigo") String codigo);
}
