package com.amaya.restaurante_backend.repository;

import com.amaya.restaurante_backend.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaRepository extends JpaRepository<Mesa, Integer> {
    // No necesitamos métodos extra por ahora
}
