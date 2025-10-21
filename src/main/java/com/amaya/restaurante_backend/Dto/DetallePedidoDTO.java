package com.amaya.restaurante_backend.Dto;

import com.amaya.restaurante_backend.entity.RolProducto;

public class DetallePedidoDTO {
    private Integer idProducto;
    private String descripcion; // antes era nombreProducto
    private Integer cantidad;
    private RolProducto rol;

    // Getters y setters
    public Integer getIdProducto() { return idProducto; }
    public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public RolProducto getRol() { return rol; }
    public void setRol(RolProducto rol) { this.rol = rol; }
}

