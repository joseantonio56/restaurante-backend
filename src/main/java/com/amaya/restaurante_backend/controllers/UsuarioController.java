package com.amaya.restaurante_backend.controllers;

import com.amaya.restaurante_backend.entity.Usuario;
import com.amaya.restaurante_backend.service.UsuarioService;
import com.amaya.restaurante_backend.Dto.MensajeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") // Permite que Angular acceda a la API
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Listar todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    // Crear usuario
    @PostMapping
    public ResponseEntity<MensajeDTO> crearUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioService.guardarUsuario(usuario);
            return ResponseEntity.ok(new MensajeDTO("Usuario creado correctamente", "SUCCESS"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new MensajeDTO(e.getMessage(), "ERROR"));
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable Integer id) {
        var usuarioOpt = usuarioService.obtenerUsuarioPorId(id);
        if (usuarioOpt.isPresent()) {
            return ResponseEntity.ok(usuarioOpt.get());
        } else {
            return ResponseEntity.status(404).body(new MensajeDTO("Usuario no encontrado", "ERROR"));
        }
    }



    // Actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<MensajeDTO> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        try {
            usuario.setIdUsuario(id);
            usuarioService.guardarUsuario(usuario);
            return ResponseEntity.ok(new MensajeDTO("Usuario actualizado correctamente", "SUCCESS"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new MensajeDTO(e.getMessage(), "ERROR"));
        }
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<MensajeDTO> eliminarUsuario(@PathVariable Integer id) {
        if (usuarioService.obtenerUsuarioPorId(id).isEmpty()) {
            return ResponseEntity.status(404).body(new MensajeDTO("Usuario no encontrado", "ERROR"));
        }
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok(new MensajeDTO("Usuario eliminado correctamente", "SUCCESS"));
    }
}
