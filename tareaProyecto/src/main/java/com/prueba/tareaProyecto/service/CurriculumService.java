package com.prueba.tareaProyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.tareaProyecto.entity.Curriculum;
import com.prueba.tareaProyecto.repository.CurriculumRepository;


@Service
public class CurriculumService {
	private final CurriculumRepository curriculumRepository;
	
	@Autowired
	public CurriculumService(CurriculumRepository curriculumRepository) {
		this.curriculumRepository = curriculumRepository;
	}
	
    public List<Curriculum> listarTodos() {
        return curriculumRepository.findAll();
    }

    public Optional<Curriculum> obtenerPorId(Long id) {
        return curriculumRepository.findById(id);
    }

    public Curriculum guardarCurriculum(Curriculum curriculum) {
        return curriculumRepository.save(curriculum);
    }
    
    public void eliminarCurriculum(Long id) {
    	curriculumRepository.deleteById(id);
    }
}
