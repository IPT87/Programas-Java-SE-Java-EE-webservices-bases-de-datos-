package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.CursosService;

@Controller
public class CursosAlumnoController {
	@Autowired
	CursosService service;
	
	@PostMapping(value = "doCursosAlumno")
	public String cursosAlumno(@RequestParam("usuario") String usuario, Model model) {
		model.addAttribute("cursosalumno", service.cursosAlumno(usuario));
		return "cursosalumno";
	}

}
