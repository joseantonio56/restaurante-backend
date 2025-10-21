package com.amaya.restaurante_backend.service;

import com.amaya.restaurante_backend.Dto.MensajeDTO;
import com.amaya.restaurante_backend.entity.Producto;
import com.amaya.restaurante_backend.repository.ProductoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Listar todos los productos
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    // Crear producto
    public ResponseEntity<?> crearProducto(Producto producto) {
        if (productoRepository.findByDescripcion(producto.getDescripcion()).isPresent()) {
            return ResponseEntity.badRequest()
                    .body(new MensajeDTO("Ya existe un producto con esa descripción", "ERROR"));
        }

        Producto nuevoProducto = productoRepository.save(producto);
        return ResponseEntity.ok(new MensajeDTO("Producto creado correctamente", "Producto creado"));
    }

    // Obtener producto por ID
    public Optional<Producto> obtenerProductoPorId(Integer id) {
        return productoRepository.findById(id);
    }

    // Actualizar producto
    public ResponseEntity<?> actualizarProducto(Integer id, Producto productoActualizado) {
        Optional<Producto> productoOpt = productoRepository.findById(id);
        if (productoOpt.isPresent()) {
            Producto producto = productoOpt.get();

            // Validar que no haya otro producto con la misma descripción
            Optional<Producto> otro = productoRepository.findByDescripcion(productoActualizado.getDescripcion());
            if (otro.isPresent() && !otro.get().getIdProducto().equals(id)) {
                return ResponseEntity.badRequest()
                        .body(new MensajeDTO("Ya existe otro producto con esa descripción", "ERROR"));
            }

            producto.setDescripcion(productoActualizado.getDescripcion());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setStock(productoActualizado.getStock());
            producto.setActivo(productoActualizado.isActivo());

            productoRepository.save(producto);
            return ResponseEntity.ok(new MensajeDTO("Producto actualizado correctamente", "Producto actualizado"));
        } else {
            return ResponseEntity.status(404).body(new MensajeDTO("Producto no encontrado", "ERROR"));
        }
    }

    // Eliminar producto
    public ResponseEntity<?> eliminarProducto(Integer id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return ResponseEntity.ok(new MensajeDTO("Producto eliminado correctamente", "Producto eliminado"));
        } else {
            return ResponseEntity.status(404).body(new MensajeDTO("Producto no encontrado", "ERROR"));
        }
    }
}
