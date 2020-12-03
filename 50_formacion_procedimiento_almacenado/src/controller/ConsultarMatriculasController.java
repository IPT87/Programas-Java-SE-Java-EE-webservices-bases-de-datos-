package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.MatriculasService;

/**
 * Servlet implementation class ConsultarMatriculasAction
 */
@Controller
public class ConsultarMatriculasController {
	@Autowired
	MatriculasService service;
	@PostMapping("doConsultarMatriculas")
	public String matriculas(HttpServletRequest request, @RequestParam("fecha1") String fecha1, @RequestParam("fecha2") String fecha2) {
		request.setAttribute("matriculas", service.consultarMatriculas(fecha1,fecha2));
		return "matriculas";
	}
	

}
