package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.CursosService;

@Controller
public class CursosMatricularController {
	@Autowired
	CursosService service;
	
	@PostMapping(value = "doSeleccionCursoMatricular")
	public String cursosMatricular(@RequestParam("usuario") String usuario, HttpSession sesion, Model model) {
		sesion.setAttribute("usuario", usuario);
		model.addAttribute("cursosmatricular", service.cursosDisponibles(usuario));
		return "cursosmatricular";
	}

}
