package com.amaya.restaurante_backend.controllers;

import com.amaya.restaurante_backend.Dto.MensajeDTO;
import com.amaya.restaurante_backend.Dto.PedidoCrearDTO;
import com.amaya.restaurante_backend.entity.EstadoPedido;
import com.amaya.restaurante_backend.entity.Pedido;
import com.amaya.restaurante_backend.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // Crear pedido con productos
    @PostMapping("/crear")
    public ResponseEntity<?> crearPedido(@RequestBody PedidoCrearDTO pedidoDTO) {
        return pedidoService.crearPedido(pedidoDTO);
    }

    // Listar pedidos
    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        return ResponseEntity.ok(pedidoService.listarPedidos());
    }

    // Obtener pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPedido(@PathVariable Integer id) {
        Optional<Pedido> pedidoOpt = pedidoService.obtenerPedidoPorId(id);
        if (pedidoOpt.isPresent()) {
            return ResponseEntity.ok(pedidoOpt.get());
        } else {
            return ResponseEntity.status(404)
                    .body(new MensajeDTO("Pedido no encontrado", "ERROR"));
        }
    }

    // Cambiar estado del pedido
    @PutMapping("/{id}/estado")
    public ResponseEntity<?> cambiarEstado(@PathVariable Integer id, @RequestParam EstadoPedido estado) {
        return pedidoService.cambiarEstado(id, estado);
    }

    // Eliminar pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPedido(@PathVariable Integer id) {
        return pedidoService.eliminarPedido(id);
    }
}
