package com.amaya.restaurante_backend.Dto;

import com.amaya.restaurante_backend.entity.DetalleVenta;
import com.amaya.restaurante_backend.entity.Venta;
import java.util.List;

public class VentaRequestDTO {

    private Venta venta;
    private List<DetalleVenta> detalles;

    public VentaRequestDTO() {}

    public VentaRequestDTO(Venta venta, List<DetalleVenta> detalles) {
        this.venta = venta;
        this.detalles = detalles;
    }

    // Getters y Setters
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }
}
