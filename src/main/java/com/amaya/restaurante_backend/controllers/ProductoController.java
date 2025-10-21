package com.amaya.restaurante_backend.controllers;

import com.amaya.restaurante_backend.Dto.MensajeDTO;
import com.amaya.restaurante_backend.entity.Producto;
import com.amaya.restaurante_backend.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // Listar todos los productos
    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() {
        return ResponseEntity.ok(productoService.listarProductos());
    }

    // Crear un producto
    @PostMapping
    public ResponseEntity<?> crearProducto(@RequestBody Producto producto) {
        return productoService.crearProducto(producto);
    }

    // Obtener producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerProducto(@PathVariable Integer id) {
        Optional<Producto> productoOpt = productoService.obtenerProductoPorId(id);

        if (productoOpt.isPresent()) {
            return ResponseEntity.ok(productoOpt.get());
        } else {
            return ResponseEntity.status(404)
                    .body(new MensajeDTO("Producto no encontrado", "ERROR"));
        }
    }

    // Actualizar producto
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        return productoService.actualizarProducto(id, producto);
    }

    // Eliminar producto
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Integer id) {
        return productoService.eliminarProducto(id);
    }
}
