package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.CursosService;

@Controller
public class CursosMatricularController {
	@Autowired
	CursosService service;
	
	@PostMapping(value = "doSeleccionAlumnoMatricular")
	public String cursosMatricular(@RequestParam("usuario") String usuario, HttpSession sesion, HttpServletRequest request) {
		sesion.setAttribute("usuario", usuario);
		request.setAttribute("cursosmatricular", service.cursosDisponibles(usuario));
		return "alumnosmatricular";
	}

}
