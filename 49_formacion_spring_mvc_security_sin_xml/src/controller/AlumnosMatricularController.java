package controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import service.AlumnosService;

@Controller
public class AlumnosMatricularController {
	@Autowired
	AlumnosService service;
	
	@GetMapping(value = "doSeleccionAlumnoMatricular")
	public String seleccionAlumnoMatricular(HttpServletRequest request) {
		request.setAttribute("alumnos", service.alumnos());
		return "alumnosmatricular"; 
	}

}
