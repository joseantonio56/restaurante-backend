package com.amaya.restaurante_backend.Dto;

import com.amaya.restaurante_backend.entity.Mesa;
import com.amaya.restaurante_backend.entity.Usuario;
import com.amaya.restaurante_backend.entity.Venta;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class VentaResponseDTO {

    private Integer idVenta;
    private LocalDateTime fecha;
    private Double total;
    private UsuarioDTO usuario;
    private MesaDTO mesa;
    private List<DetalleVentaResponseDTO> detalles;

    public VentaResponseDTO() {}

    public VentaResponseDTO(Venta venta) {
        this.idVenta = venta.getIdVenta();
        this.fecha = venta.getFecha();
        this.total = venta.getTotal();

        if (venta.getUsuario() != null) {
            this.usuario = new UsuarioDTO(venta.getUsuario());
        }

        if (venta.getMesa() != null) {
            this.mesa = new MesaDTO(venta.getMesa());
        }

        if (venta.getDetalles() != null) {
            this.detalles = venta.getDetalles().stream()
                    .map(DetalleVentaResponseDTO::new)
                    .collect(Collectors.toList());
        }
    }

    // Getters y Setters
    public Integer getIdVenta() { return idVenta; }
    public void setIdVenta(Integer idVenta) { this.idVenta = idVenta; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
    public UsuarioDTO getUsuario() { return usuario; }
    public void setUsuario(UsuarioDTO usuario) { this.usuario = usuario; }
    public MesaDTO getMesa() { return mesa; }
    public void setMesa(MesaDTO mesa) { this.mesa = mesa; }
    public List<DetalleVentaResponseDTO> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleVentaResponseDTO> detalles) { this.detalles = detalles; }

    // Clase interna UsuarioDTO
    public static class UsuarioDTO {
        private Integer idUsuario;
        private String nombre;
        private String email;
        private String rol;

        public UsuarioDTO() {}

        public UsuarioDTO(Usuario usuario) {
            this.idUsuario = usuario.getIdUsuario();
            this.nombre = usuario.getNombre();
            this.email = usuario.getEmail();
            // Convertir Enum a String para evitar errores
            this.rol = usuario.getRol() != null ? usuario.getRol().name() : "";
        }

        // Getters y Setters
        public Integer getIdUsuario() { return idUsuario; }
        public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getRol() { return rol; }
        public void setRol(String rol) { this.rol = rol; }
    }

    // Clase interna MesaDTO
    public static class MesaDTO {
        private Integer id;
        private String estado;

        public MesaDTO() {}

        public MesaDTO(Mesa mesa) {
            this.id = mesa.getId();
            if (mesa.getEstado() != null) {
                this.estado = mesa.getEstado().name();
            }
        }

        // Getters y Setters
        public Integer getId() { return id; }
        public void setId(Integer id) { this.id = id; }
        public String getEstado() { return estado; }
        public void setEstado(String estado) { this.estado = estado; }
    }
}
