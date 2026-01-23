package com.prueba.tareaProyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.tareaProyecto.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
