package com.amaya.restaurante_backend.Dto;

public class ProductoPedidoDTO {

    private Integer idProducto;
    private Integer cantidad;

    public ProductoPedidoDTO() {}

    public ProductoPedidoDTO(Integer idProducto, Integer cantidad) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    // Getters y setters
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
