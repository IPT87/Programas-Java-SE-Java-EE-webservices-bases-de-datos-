package controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.DtoCurso;
import dto.Utilidades;
import service.CursosService;

@CrossOrigin(value = "*")
@Controller
public class CursosMatricularController {
	@Autowired
	CursosService service;
	
	@GetMapping(value = "doSeleccionCursoMatricular", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<DtoCurso> cursosMatricular(@RequestParam("usuario") String usuario, HttpSession sesion) {
		sesion.setAttribute("usuario", usuario);
		
		return service.cursosDisponibles(usuario)
									.stream()
									.map(curso -> Utilidades.convertirADtoCurso(curso))
									.collect(Collectors.toList());
	}

}
