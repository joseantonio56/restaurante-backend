package com.amaya.restaurante_backend.repository;

import com.amaya.restaurante_backend.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MesaRepository extends JpaRepository<Mesa, Integer> {
    List<Mesa> findAllByOrderByIdAsc();
}
