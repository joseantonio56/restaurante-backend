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
        return mesaRepository.findAllByOrderByIdAsc();
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

        // Cambiar estado: si está LIBRE, pasa a OCUPADA, si está OCUPADA, pasa a LIBRE
        if (mesa.getEstado() == EstadoMesa.LIBRE) {
            mesa.setEstado(EstadoMesa.OCUPADA);
        } else {
            mesa.setEstado(EstadoMesa.LIBRE);
        }

        // Guardar la mesa con el nuevo estado
        return mesaRepository.save(mesa);
    }

    // Eliminar una mesa por id
    public void eliminarMesa(Integer id) {
        Mesa mesa = mesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa no encontrada"));
        mesaRepository.delete(mesa);
    }


}
