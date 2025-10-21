package com.amaya.restaurante_backend.service;

import com.amaya.restaurante_backend.Dto.MensajeDTO;
import com.amaya.restaurante_backend.Dto.PedidoCrearDTO;
import com.amaya.restaurante_backend.Dto.ProductoPedidoDTO;
import com.amaya.restaurante_backend.entity.DetallePedido;
import com.amaya.restaurante_backend.entity.EstadoPedido;
import com.amaya.restaurante_backend.entity.Pedido;
import com.amaya.restaurante_backend.entity.Producto;
import com.amaya.restaurante_backend.entity.Mesa;
import com.amaya.restaurante_backend.entity.Usuario;
import com.amaya.restaurante_backend.repository.DetallePedidoRepository;
import com.amaya.restaurante_backend.repository.MesaRepository;
import com.amaya.restaurante_backend.repository.PedidoRepository;
import com.amaya.restaurante_backend.repository.ProductoRepository;
import com.amaya.restaurante_backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    // Crear pedido con productos
    public ResponseEntity<?> crearPedido(PedidoCrearDTO pedidoDTO) {

        Optional<Mesa> mesaOpt = mesaRepository.findById(pedidoDTO.getIdMesa());
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(pedidoDTO.getIdUsuario());

        if (mesaOpt.isEmpty() || usuarioOpt.isEmpty()) {
            return ResponseEntity.badRequest().body(new MensajeDTO("Mesa o usuario no encontrados", "ERROR"));
        }

        Pedido pedido = new Pedido();
        pedido.setMesa(mesaOpt.get());
        pedido.setUsuario(usuarioOpt.get());
        pedido.setEstado(EstadoPedido.PENDIENTE);

        List<DetallePedido> detalles = new ArrayList<>();

        for (ProductoPedidoDTO p : pedidoDTO.getProductos()) {
            Optional<Producto> prodOpt = productoRepository.findById(p.getIdProducto());
            if (prodOpt.isPresent()) {
                DetallePedido detalle = new DetallePedido();
                detalle.setPedido(pedido);
                detalle.setProducto(prodOpt.get());
                detalle.setCantidad(p.getCantidad());
                detalles.add(detalle);
            }
        }

        // Guardar primero el pedido para que tenga ID
        pedidoRepository.save(pedido);

        // Guardar los detalles con el pedido asociado
        for (DetallePedido d : detalles) {
            detallePedidoRepository.save(d);
        }

        return ResponseEntity.ok(new MensajeDTO("Pedido creado correctamente", "OK"));
    }

    // Listar pedidos
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    // Obtener pedido por ID
    public Optional<Pedido> obtenerPedidoPorId(Integer id) {
        return pedidoRepository.findById(id);
    }

    // Cambiar estado del pedido
    public ResponseEntity<?> cambiarEstado(Integer id, EstadoPedido nuevoEstado) {
        Optional<Pedido> pedidoOpt = pedidoRepository.findById(id);

        if (pedidoOpt.isEmpty()) {
            return ResponseEntity.status(404).body(new MensajeDTO("Pedido no encontrado", "ERROR"));
        }

        Pedido pedido = pedidoOpt.get();
        pedido.setEstado(nuevoEstado);
        pedidoRepository.save(pedido);

        return ResponseEntity.ok(new MensajeDTO("Estado del pedido actualizado a " + nuevoEstado, "OK"));
    }

    // Eliminar pedido
    public ResponseEntity<?> eliminarPedido(Integer id) {
        if (!pedidoRepository.existsById(id)) {
            return ResponseEntity.status(404).body(new MensajeDTO("Pedido no encontrado", "ERROR"));
        }
        pedidoRepository.deleteById(id);
        return ResponseEntity.ok(new MensajeDTO("Pedido eliminado correctamente", "OK"));
    }
}
