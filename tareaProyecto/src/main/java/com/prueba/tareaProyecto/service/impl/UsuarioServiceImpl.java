package com.prueba.tareaProyecto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.tareaProyecto.entity.Usuario;
import com.prueba.tareaProyecto.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl {
	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
    
    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    

    
    public void eliminarUsuario(Long id) {
    	usuarioRepository.deleteById(id);
    }
}
