package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import service.AlumnosService;

@Controller
public class AlumnosMatricularController {
	@Autowired
	AlumnosService service;
	
	@GetMapping(value = "doSeleccionAlumnoMatricular")
	public String seleccionAlumnoMatricular(Model model) {
		model.addAttribute("alumnos", service.alumnos());
		return "alumnosmatricular"; 
	}

}
