package com.prueba.tareaProyecto.service;

import java.util.List;

import com.prueba.tareaProyecto.entity.Curriculum;

public interface CurriculumService {
	List<Curriculum> listarTodos();
	Curriculum obtenerPorIdOExcepcion(Long id);
	Curriculum guardarCurriculum(Curriculum curriculum);
	void eliminarCurriculum(Long id);
	void eliminarPorId(Long id);
}
