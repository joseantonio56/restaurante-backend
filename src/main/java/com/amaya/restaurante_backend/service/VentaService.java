package com.amaya.restaurante_backend.service;

import com.amaya.restaurante_backend.Dto.MensajeDTO;
import com.amaya.restaurante_backend.entity.DetalleVenta;
import com.amaya.restaurante_backend.entity.Producto;
import com.amaya.restaurante_backend.entity.Venta;
import com.amaya.restaurante_backend.repository.DetalleVentaRepository;
import com.amaya.restaurante_backend.repository.ProductoRepository;
import com.amaya.restaurante_backend.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    // Crear venta con detalles
    public ResponseEntity<?> crearVenta(Venta venta, List<DetalleVenta> detalles) {
        venta.setFecha(LocalDateTime.now());

        // Calcular total
        double total = detalles.stream()
                .mapToDouble(d -> d.getPrecio() * d.getCantidad())
                .sum();
        venta.setTotal(total);

        // Guardar la venta primero
        ventaRepository.save(venta);

        // Procesar detalles y actualizar stock
        for (DetalleVenta detalle : detalles) {
            Producto producto = productoRepository.findById(detalle.getProducto().getIdProducto())
                    .orElse(null);

            if (producto == null) {
                return ResponseEntity
                        .badRequest()
                        .body(new MensajeDTO("Producto no encontrado: ID " + detalle.getProducto().getIdProducto(), "Error"));
            }

            if (producto.getStock() < detalle.getCantidad()) {
                return ResponseEntity
                        .badRequest()
                        .body(new MensajeDTO("Stock insuficiente para el producto: " + producto.getDescripcion(), "Error"));
            }

            // Restar stock
            producto.setStock(producto.getStock() - detalle.getCantidad());
            productoRepository.save(producto);

            // Asignar la venta al detalle y guardar
            detalle.setVenta(venta);
            detalleVentaRepository.save(detalle);
        }

        return ResponseEntity.ok(new MensajeDTO("Venta creada correctamente y stock actualizado", "Éxito"));
    }

    // Listar todas las ventas
    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    // Obtener venta por ID
    public Venta obtenerVentaPorId(Integer id) {
        return ventaRepository.findById(id).orElse(null);
    }
}
