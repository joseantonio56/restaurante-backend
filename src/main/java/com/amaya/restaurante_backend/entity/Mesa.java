package com.amaya.restaurante_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mesa")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoMesa estado; // LIBRE o OCUPADA

    // Constructor vacío
    public Mesa() {}

    // Constructor con parámetros
    public Mesa(EstadoMesa estado) {
        this.estado = estado;
    }

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoMesa getEstado() {
        return estado;
    }

    public void setEstado(EstadoMesa estado) {
        this.estado = estado;
    }
}
