package com.amaya.restaurante_backend.repository;

import com.amaya.restaurante_backend.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {}
