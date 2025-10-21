package com.amaya.restaurante_backend.service;

import com.amaya.restaurante_backend.entity.Usuario;
import com.amaya.restaurante_backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Listar todos los usuarios
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Guardar usuario (crear o actualizar)
    public Usuario guardarUsuario(Usuario usuario) {
        // Validar email único solo si es nuevo usuario o si cambia el email
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent() && !usuarioExistente.get().getIdUsuario().equals(usuario.getIdUsuario())) {
            throw new IllegalArgumentException("Ya existe un usuario con este email");
        }
        return usuarioRepository.save(usuario);
    }

    // Obtener usuario por ID
    public Optional<Usuario> obtenerUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    // Eliminar usuario
    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
