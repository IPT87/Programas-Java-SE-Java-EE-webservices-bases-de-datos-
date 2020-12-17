package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.CursosService;

@Controller
public class CursosController {
	@Autowired
	CursosService service;
	
	@GetMapping(value = "doCursos")
	public String cursos(Model model) {
		model.addAttribute("cursos", service.obtenerCursos());
		return "seleccioncursos";
	}
}
