package com.amaya.restaurante_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private boolean activo = true; // true = disponible, false = no disponible

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RolProducto rol; // BARRA o COCINA

    // Constructor vacío
    public Producto() {}

    // Constructor con parámetros
    public Producto(String descripcion, Integer stock, Double precio, boolean activo, RolProducto rol) {
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.activo = activo;
        this.rol = rol;
    }

    // Getters y setters
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public RolProducto getRol() {
        return rol;
    }

    public void setRol(RolProducto rol) {
        this.rol = rol;
    }
}
