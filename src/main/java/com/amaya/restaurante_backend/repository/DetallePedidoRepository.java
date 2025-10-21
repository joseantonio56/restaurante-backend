package com.amaya.restaurante_backend.repository;

import com.amaya.restaurante_backend.entity.DetallePedido;
import com.amaya.restaurante_backend.entity.Pedido;
import com.amaya.restaurante_backend.entity.RolProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {

    // Obtener todos los detalles de un pedido filtrados por rol de producto
    List<DetallePedido> findByPedidoAndProductoRol(Pedido pedido, RolProducto rol);
}
