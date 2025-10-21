package com.amaya.restaurante_backend.Dto;

public class ProductoDetalleDTO {

    private String descripcion;
    private Double precio;
    private String rol;
    private Integer cantidad;

    // Constructor vacío
    public ProductoDetalleDTO() {}

    // Constructor con parámetros
    public ProductoDetalleDTO(String descripcion, Double precio, String rol, Integer cantidad) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.rol = rol;
        this.cantidad = cantidad;
    }

    // Getters y setters
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
}
