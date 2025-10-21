package com.amaya.restaurante_backend.Dto;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoDTO {

    private Integer idPedido;
    private Integer mesaId;
    private String usuarioNombre;
    private String estado;
    private LocalDateTime fechaHora;
    private List<ProductoDetalleDTO> productos;

    // Constructor vacío
    public PedidoDTO() {}

    // Constructor con parámetros
    public PedidoDTO(Integer idPedido, Integer mesaId, String usuarioNombre, String estado, LocalDateTime fechaHora, List<ProductoDetalleDTO> productos) {
        this.idPedido = idPedido;
        this.mesaId = mesaId;
        this.usuarioNombre = usuarioNombre;
        this.estado = estado;
        this.fechaHora = fechaHora;
        this.productos = productos;
    }

    // Getters y setters
    public Integer getIdPedido() { return idPedido; }
    public void setIdPedido(Integer idPedido) { this.idPedido = idPedido; }

    public Integer getMesaId() { return mesaId; }
    public void setMesaId(Integer mesaId) { this.mesaId = mesaId; }

    public String getUsuarioNombre() { return usuarioNombre; }
    public void setUsuarioNombre(String usuarioNombre) { this.usuarioNombre = usuarioNombre; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public List<ProductoDetalleDTO> getProductos() { return productos; }
    public void setProductos(List<ProductoDetalleDTO> productos) { this.productos = productos; }
}
