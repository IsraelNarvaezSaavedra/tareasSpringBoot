package com.prueba.tareaProyecto.service;

import java.util.List;
import java.util.Optional;

import com.prueba.tareaProyecto.entity.Usuario;

public interface UsuarioService {
	List<Usuario> listarTodos();
	Optional<Usuario> obtenerPorId(Long id);
	Usuario guardarUsuario(Usuario usuario);
	void eliminarUsuario(Long id);
}
