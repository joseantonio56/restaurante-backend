package com.amaya.restaurante_backend.Dto;

import com.amaya.restaurante_backend.entity.DetalleVenta;
import com.amaya.restaurante_backend.entity.Producto;

public class DetalleVentaResponseDTO {

    private Integer idDetalle;
    private Integer cantidad;
    private Double precio;
    private ProductoDTO producto;

    public DetalleVentaResponseDTO() {}

    public DetalleVentaResponseDTO(DetalleVenta detalle) {
        this.idDetalle = detalle.getIdDetalle();
        this.cantidad = detalle.getCantidad();
        this.precio = detalle.getPrecio();
        if (detalle.getProducto() != null) {
            this.producto = new ProductoDTO(detalle.getProducto());
        }
    }

    // Getters y Setters
    public Integer getIdDetalle() { return idDetalle; }
    public void setIdDetalle(Integer idDetalle) { this.idDetalle = idDetalle; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public ProductoDTO getProducto() { return producto; }
    public void setProducto(ProductoDTO producto) { this.producto = producto; }

    // DTO interno para Producto
    public static class ProductoDTO {
        private Integer idProducto;
        private String descripcion;
        private Double precio;
        private String rol;

        public ProductoDTO() {}

        public ProductoDTO(Producto producto) {
            this.idProducto = producto.getIdProducto();
            this.descripcion = producto.getDescripcion();
            this.precio = producto.getPrecio();
            if (producto.getRol() != null) {
                this.rol = producto.getRol().name();
            }
        }

        // Getters y Setters
        public Integer getIdProducto() { return idProducto; }
        public void setIdProducto(Integer idProducto) { this.idProducto = idProducto; }
        public String getDescripcion() { return descripcion; }
        public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
        public Double getPrecio() { return precio; }
        public void setPrecio(Double precio) { this.precio = precio; }
        public String getRol() { return rol; }
        public void setRol(String rol) { this.rol = rol; }
    }
}
