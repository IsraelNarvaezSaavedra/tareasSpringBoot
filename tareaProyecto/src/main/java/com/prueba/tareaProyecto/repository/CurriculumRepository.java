package com.prueba.tareaProyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.tareaProyecto.entity.Curriculum;

public interface CurriculumRepository  extends JpaRepository<Curriculum, Long>  {

}
