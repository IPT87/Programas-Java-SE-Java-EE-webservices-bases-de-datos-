package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Curso;
import service.CursosService;

@Controller
public class AltaCursoController {
	@Autowired
	CursosService service;
		
	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");

	@PostMapping(value = "doAltaCurso")
	public String altaCurso(@RequestParam("fechaInicio") String fechaInicio, @RequestParam("nombre") String nombre,
			@RequestParam("duracion") int duracion) {
		Curso curso = null;
		try {
			curso = new Curso(0,duracion,format.parse(fechaInicio),nombre);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		service.altaCurso(curso);
		
		return "menu";
	}
}
