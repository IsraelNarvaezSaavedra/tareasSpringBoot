package com.prueba.tareaProyecto.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.tareaProyecto.entity.Curriculum;
import com.prueba.tareaProyecto.repository.CurriculumRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class CurriculumServiceImpl {
	private final CurriculumRepository curriculumRepository;
	
	@Autowired
	public CurriculumServiceImpl(CurriculumRepository curriculumRepository) {
		this.curriculumRepository = curriculumRepository;
	}
	
    public List<Curriculum> listarTodos() {
        return curriculumRepository.findAll();
    }
    
    //Esta funcion es asi porque devuelve un optional y no un curriculum directo, es necesario el orElseThrow para que funcione
    public Curriculum obtenerPorIdOExcepcion(Long id) {
        return curriculumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curriculum no encontrado con ID: " + id));
    }

    public Curriculum guardarCurriculum(Curriculum curriculum) {
        return curriculumRepository.save(curriculum);
    }
    
    public void eliminarCurriculum(Long id) {
    	curriculumRepository.deleteById(id);
    }
    public void eliminarPorId(Long id) {
        curriculumRepository.deleteById(id);
    }
    
    public Page<Curriculum> listarTodosLosCurriculums(Pageable pageable) {
        return curriculumRepository.findAll(pageable);
    }
}
