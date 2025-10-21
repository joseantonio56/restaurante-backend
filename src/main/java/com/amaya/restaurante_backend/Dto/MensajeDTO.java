package com.amaya.restaurante_backend.Dto;

public class MensajeDTO {

    private String mensaje;
    private String status;

    // Constructor vacío
    public MensajeDTO() {}

    // Constructor con parámetros
    public MensajeDTO(String mensaje, String status) {
        this.mensaje = mensaje;
        this.status = status;
    }

    // Getters y setters
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
