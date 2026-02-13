package com.prueba.tareaProyecto.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.tareaProyecto.entity.Curriculum;

public interface CurriculumRepository  extends JpaRepository<Curriculum, Long>  {
	List<Curriculum> findByUsuarioNombre(String nombre);
	
	Page<Curriculum> findAll(Pageable pageable);
	Page<Curriculum> findByUsuarioNombre(String nombre, Pageable pageable);
	Page<Curriculum> findByUsuarioNombreContaining(String nomrbre, Pageable pageable);
}
