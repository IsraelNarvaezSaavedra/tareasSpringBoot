package com.prueba.tareaProyecto.configuration;
import com.github.javafaker.Faker;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.prueba.tareaProyecto.entity.Curriculum;
import com.prueba.tareaProyecto.entity.Usuario;
import com.prueba.tareaProyecto.repository.CurriculumRepository;
import com.prueba.tareaProyecto.repository.UsuarioRepository;
import com.prueba.tareaProyecto.service.CurriculumService;
import com.prueba.tareaProyecto.service.UsuarioService;

import jakarta.annotation.PostConstruct;

@Component
public class InicializarDatos implements CommandLineRunner{

    private final CurriculumService curriculumService;


	 @Autowired
	    private CurriculumRepository curriculumRepository;

	    @Autowired
	    private UsuarioRepository usuarioRepository;
	    
	    @Autowired
	    private UsuarioService usuarioService;

    InicializarDatos(CurriculumService curriculumService) {
        this.curriculumService = curriculumService;
    }

	@Override
	public void run(String... args) throws Exception {

		 Faker faker = new Faker();
	        List<Usuario> usuarios = new ArrayList<>();

	        // Crear 10 usuarios
	        for (int i = 0; i < 10; i++) {
	        	Usuario usuario = new Usuario();
	            usuario.setNombre(faker.name().firstName());
	            usuarios.add(usuario);
	            usuarioService.guardarUsuario(usuario);
	            
	            // Para cada usuario, crea de 1 a 3 curriculums
	            Date desde = new Date(1900, 0, 1); 
	            Date hasta = new Date(2010, 0, 1);
	            Curriculum curriculum = new Curriculum();
                curriculum.setUrl(faker.internet().url());
                curriculum.setContenido(faker.chuckNorris().fact());
                curriculum.setUsuario(usuario);
                curriculum.setFechaCreacion( faker.date().between(desde, hasta));
                usuario.getCurriculums().add(curriculum);
                curriculumService.guardarCurriculum(curriculum);
	        }
	}
}

