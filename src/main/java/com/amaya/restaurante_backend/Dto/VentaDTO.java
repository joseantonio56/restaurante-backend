package com.amaya.restaurante_backend.dto;

import com.amaya.restaurante_backend.Dto.DetalleVentaDTO;
import com.amaya.restaurante_backend.entity.DetalleVenta;
import com.amaya.restaurante_backend.entity.Producto;
import com.amaya.restaurante_backend.entity.Usuario;
import com.amaya.restaurante_backend.entity.Mesa;

import java.util.ArrayList;
import java.util.List;

public class VentaDTO {

    private Integer idUsuario;
    private Integer idMesa;
    private List<DetalleVentaDTO> detalles;

    // Getters y Setters
    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
    public Integer getIdMesa() { return idMesa; }
    public void setIdMesa(Integer idMesa) { this.idMesa = idMesa; }
    public List<DetalleVentaDTO> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleVentaDTO> detalles) { this.detalles = detalles; }

    // Convertir a entidad Venta
    public com.amaya.restaurante_backend.entity.Venta toVenta() {
        com.amaya.restaurante_backend.entity.Venta venta = new com.amaya.restaurante_backend.entity.Venta();
        venta.setUsuario(new Usuario());
        venta.getUsuario().setIdUsuario(this.idUsuario);
        venta.setMesa(new Mesa());
        venta.getMesa().setId(this.idMesa);
        return venta;
    }

    // Convertir detalles a entidades DetalleVenta
    public List<DetalleVenta> toDetallesVenta() {
        List<DetalleVenta> lista = new ArrayList<>();
        for (DetalleVentaDTO dto : detalles) {
            DetalleVenta dv = new DetalleVenta();
            dv.setCantidad(dto.getCantidad());
            dv.setPrecio(dto.getPrecio());
            Producto producto = new Producto();
            producto.setIdProducto(dto.getIdProducto());
            dv.setProducto(producto);
            lista.add(dv);
        }
        return lista;
    }
}
