package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.CursosService;

/**
 * Servlet implementation class CursosMatricularAction
 */
@Controller
public class CursosMatricularController {
	@Autowired
	CursosService service;
	@PostMapping("doSeleccionCursoMatricular")
	public String cursosMatricular(HttpServletRequest request, HttpSession sesion, @RequestParam("usuario") String usuario) {
		sesion.setAttribute("usuario", usuario);//se recuerde a la hora de matricular
		request.setAttribute("cursosmatricular", service.cursosDisponibles(usuario));
		return "cursosmatricular";
	}

}
