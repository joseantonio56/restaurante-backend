package com.amaya.restaurante_backend.Dto;

import java.util.List;

public class PedidoCrearDTO {

    private Integer idMesa;
    private Integer idUsuario;
    private List<ProductoPedidoDTO> productos;

    public PedidoCrearDTO() {}

    public PedidoCrearDTO(Integer idMesa, Integer idUsuario, List<ProductoPedidoDTO> productos) {
        this.idMesa = idMesa;
        this.idUsuario = idUsuario;
        this.productos = productos;
    }

    // Getters y setters
    public Integer getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<ProductoPedidoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoPedidoDTO> productos) {
        this.productos = productos;
    }
}
