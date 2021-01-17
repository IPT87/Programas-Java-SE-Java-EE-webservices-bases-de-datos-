package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.DtoCurso;
import dto.Utilidades;
import model.Curso;
import service.CursosService;

@RestController
public class FormacionController {
	@Autowired
	CursosService service;
	
	@GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DtoCurso> cursos() {
		List<DtoCurso> cursos = new ArrayList<>();
		
		service.obtenerCursos()
				.stream()
				.forEach(c -> cursos.add(Utilidades.convertirADtoCurso(c)));
		
		return cursos;
	}
	
	@PostMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void agregarCurso(@RequestBody Curso curso) {
		service.altaCurso(curso);
	}
	
}
