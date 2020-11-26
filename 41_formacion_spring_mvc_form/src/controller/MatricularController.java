package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.MatriculasService;

@Controller
public class MatricularController {
	@Autowired
	MatriculasService service;
	
	@PostMapping(value = "doMatricular")
	public String matricular(@RequestParam("idCurso") int idCurso, @RequestParam("usuario") String usuario) {
		service.matricularAlumno(usuario, idCurso);
		return "menu";
	}

}
