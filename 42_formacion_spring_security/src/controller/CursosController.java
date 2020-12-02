package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import service.CursosService;

@Controller
public class CursosController {
	@Autowired
	CursosService service;
	
	@GetMapping(value = "doCursos")
	public String cursos(HttpServletRequest request) {
		request.setAttribute("cursos", service.obtenerCursos());
		return "seleccioncursos";
	}
}
