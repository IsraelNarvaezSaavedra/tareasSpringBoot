package com.prueba.tareaProyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prueba.tareaProyecto.entity.Usuario;
import com.prueba.tareaProyecto.service.impl.UsuarioServiceImpl;

@Controller
@RequestMapping("/urls")
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@GetMapping
	public String listarUsuarios(Model model) {
		List<Usuario> usuarios = usuarioService.listarTodos();
		model.addAttribute("usuarios",usuarios);
		return "usuarios/lista";
	}
}
