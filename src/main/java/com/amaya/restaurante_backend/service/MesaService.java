package com.amaya.restaurante_backend.service;

import com.amaya.restaurante_backend.entity.EstadoMesa;
import com.amaya.restaurante_backend.entity.Mesa;
import com.amaya.restaurante_backend.repository.MesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService {

    private final MesaRepository mesaRepository;

    public MesaService(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    // Obtener todas las mesas
    public List<Mesa> listarMesas() {
        return mesaRepository.findAll();
    }

    // Crear una nueva mesa (siempre empieza LIBRE)
    public Mesa crearMesa() {
        Mesa mesa = new Mesa(EstadoMesa.LIBRE);
        return mesaRepository.save(mesa);
    }

    // Cambiar estado de la mesa (LIBRE ↔ OCUPADA) y devolver la mesa actualizada
    public Mesa toggleEstadoMesa(Integer id) {
        Mesa mesa = mesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa no encontrada"));

        mesa.setEstado(mesa.getEstado() == EstadoMesa.LIBRE ? EstadoMesa.OCUPADA : EstadoMesa.LIBRE);
        return mesaRepository.save(mesa);
    }
    // Eliminar una mesa por id
    public void eliminarMesa(Integer id) {
        Mesa mesa = mesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa no encontrada"));
        mesaRepository.delete(mesa);
    }

}
