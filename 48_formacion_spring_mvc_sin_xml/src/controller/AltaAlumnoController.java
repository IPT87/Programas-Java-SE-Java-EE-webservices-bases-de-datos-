package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Alumno;
import service.AlumnosService;

@Controller
public class AltaAlumnoController {
	@Autowired
	AlumnosService service;

	@PostMapping(value = "doAltaAlumno")
	public String altaAlumno(@RequestParam("usuario") String usuario, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("nombre") String nombre,
			@RequestParam("edad") int edad) {
		if(service.buscarAlumnoPorUsuario(usuario) == null) {
			Alumno alumno = new Alumno(usuario, edad, email, nombre, password);
			service.altaAlumno(alumno);
			return "../menu";
		}else {
			return "usuariorepetido";
		}
	}
}
