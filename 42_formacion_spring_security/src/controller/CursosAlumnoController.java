package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.CursosService;

@Controller
public class CursosAlumnoController {
	@Autowired
	CursosService service;
	
	@PostMapping(value = "doCursosAlumno")
	public String cursosAlumno(@RequestParam("usuario") String usuario, HttpServletRequest request) {
		request.setAttribute("cursosalumno", service.cursosAlumno(usuario));
		return "cursosalumno";
	}

}
