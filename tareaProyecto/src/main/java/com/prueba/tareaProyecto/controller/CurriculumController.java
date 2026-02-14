package com.prueba.tareaProyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.prueba.tareaProyecto.entity.Curriculum;
import com.prueba.tareaProyecto.service.impl.CurriculumServiceImpl;

@Controller
public class CurriculumController {

	
	@Autowired
	private CurriculumServiceImpl curriculumService;
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	@GetMapping("/logout")
	public String showIndex() {
		return "logout";
	}
	
    @GetMapping({"/", "/galeria", "/index"})
    public String listarCurriculums (Model model,
    		@PageableDefault(size=12) Pageable page) {
    	
    	Page<Curriculum> curriculums;
    	curriculums = curriculumService.listarTodosLosCurriculums(page);
    	model.addAttribute("curriculums", curriculums);
    	model.addAttribute("total", curriculums.getTotalElements());
    	
    	return "galeria";
    }
	
	@GetMapping("/ver/{id}")
	public String verCurriculum(@PathVariable("id") Long id, Model model) {
		Curriculum curriculum = curriculumService.obtenerPorIdOExcepcion(id);
		model.addAttribute("curriculum", curriculum);
		return "ver";
	}
	
	@GetMapping("/administracion")
	public String listarCurriculum(Model model) {
		List<Curriculum> curriculums = curriculumService.listarTodos();
		model.addAttribute("curriculums",curriculums);
		System.out.println(curriculums);
		return "administracion";
	}
	
    @GetMapping("/editar/{id}")
    public String editarCorriculum(@PathVariable("id") Long id, Model model) {
        Curriculum curriculum = curriculumService.obtenerPorIdOExcepcion(id);
        if (curriculum == null) {
            return "redirect:/index";
        }
        model.addAttribute("curriculum", curriculum);
        return "editar";  
    }
    
    @PostMapping("/editar")
    public String guardarEdicion(@ModelAttribute Curriculum curriculum) {

    	Long idDelCurriculum = curriculum.getId(); 
        Curriculum curriculumOriginal = curriculumService.obtenerPorIdOExcepcion(idDelCurriculum);
        curriculumOriginal.setContenido(curriculum.getContenido());
        curriculumService.guardarCurriculum(curriculumOriginal);
        return "redirect:/administracion";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCurriculum(@PathVariable("id") Long id) {
        curriculumService.eliminarPorId(id);
        return "redirect:/administracion";  
    }

}
