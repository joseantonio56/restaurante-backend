package com.amaya.restaurante_backend.controllers;

import com.amaya.restaurante_backend.Dto.VentaRequestDTO;
import com.amaya.restaurante_backend.Dto.VentaResponseDTO;
import com.amaya.restaurante_backend.entity.Venta;
import com.amaya.restaurante_backend.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "*") // Permite que Angular acceda a la API
public class VentaController {

    @Autowired
    private VentaService ventaService;

    // Obtener todas las ventas
    @GetMapping
    public ResponseEntity<List<VentaResponseDTO>> listarVentas() {
        List<Venta> ventas = ventaService.listarVentas();
        List<VentaResponseDTO> ventasDTO = ventas.stream()
                .map(VentaResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(ventasDTO);
    }

    // Obtener venta por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerVenta(@PathVariable Integer id) {
        Venta venta = ventaService.obtenerVentaPorId(id);

        if (venta == null) {
            return ResponseEntity.status(404).body("Venta no encontrada");
        }

        VentaResponseDTO ventaDTO = new VentaResponseDTO(venta);
        return ResponseEntity.ok(ventaDTO);
    }

    // Crear venta con detalles
    @PostMapping
    public ResponseEntity<?> crearVenta(@RequestBody VentaRequestDTO ventaRequest) {
        return ventaService.crearVenta(ventaRequest.getVenta(), ventaRequest.getDetalles());
    }

}
