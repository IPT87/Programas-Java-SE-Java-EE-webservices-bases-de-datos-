package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.AlumnosService;

@Controller
public class AlumnosController {
	@Autowired
	AlumnosService service;

	@GetMapping(value = "doAlumnos")
	public String alumnos(Model model) {
		model.addAttribute("alumnos", service.alumnos());
		return "seleccionalumnos";
	}
}
