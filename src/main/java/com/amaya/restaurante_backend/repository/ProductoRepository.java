package com.amaya.restaurante_backend.repository;

import com.amaya.restaurante_backend.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    //Método para validar que no haya productos con la misma descripción
    Optional<Producto> findByDescripcion(String descripcion);
}
