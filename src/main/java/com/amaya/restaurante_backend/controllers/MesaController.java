package com.amaya.restaurante_backend.controllers;

import com.amaya.restaurante_backend.entity.Mesa;
import com.amaya.restaurante_backend.service.MesaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mesas")
@CrossOrigin
public class MesaController {

    private final MesaService mesaService;

    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    // Listar todas las mesas
    @GetMapping
    public ResponseEntity<List<Mesa>> listarMesas() {
        return ResponseEntity.ok(mesaService.listarMesas());
    }

    // Cambiar estado de la mesa (LIBRE ↔ OCUPADA)
    @PutMapping("/{id}/toggle")
    public ResponseEntity<Mesa> toggleEstado(@PathVariable Integer id) {
        Mesa mesaActualizada = mesaService.toggleEstadoMesa(id);
        return ResponseEntity.ok(mesaActualizada);
    }

    // Crear nueva mesa
    @PostMapping
    public ResponseEntity<Mesa> crearMesa() {
        return ResponseEntity.ok(mesaService.crearMesa());
    }
    // DELETE /api/mesas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMesa(@PathVariable Integer id) {
        mesaService.eliminarMesa(id);
        return ResponseEntity.ok().build(); 
    }


}
