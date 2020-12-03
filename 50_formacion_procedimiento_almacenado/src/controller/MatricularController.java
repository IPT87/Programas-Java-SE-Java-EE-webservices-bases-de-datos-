package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import service.MatriculasService;

/**
 * Servlet implementation class MatricularAction
 */
@Controller
public class MatricularController {
	@Autowired
	MatriculasService service;
	@PostMapping("doMatricular")
	public String matricular(
			@RequestParam("idCurso") int idCurso, 
			@SessionAttribute("usuario") String usuario)  {
		service.matricularAlumno(usuario, idCurso);
		return "menu";
	}

}
