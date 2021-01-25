package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Alumno;
import model.Curso;
import service.FormacionService;

@CrossOrigin("*")
@RestController
public class FormacionController {
	@Autowired
	FormacionService service;
	
	@GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Curso>> cursos() {
		
		List<Curso> body = service.todosCursos();
		HttpHeaders headers = new HttpHeaders();
		
		if (body == null || body.size() == 0) {
			headers.add("error", "No hay cursos");
		} else {
			headers.add("Total de cursos", body.size() + "");
		}
		
		return new ResponseEntity<List<Curso>>(body, headers, HttpStatus.OK);
	}
	
	@GetMapping(value = "alumnos/{idCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Alumno>> alumnos(@PathVariable("idCurso") int idCurso) {
		
		List<Alumno> body = service.todosCursos()
				.stream()
				.filter(c -> c.getIdCurso() == idCurso)
				.map(a -> a.getAlumnos())
				.findFirst()
				.orElse(null);
		
		HttpHeaders headers = new HttpHeaders();
		
		if (body == null || body.size() == 0) {
			headers.add("error", "No hay alumnos");
		} else {
			headers.add("Total de alumnos", body.size() + "");
		}
		
		return new ResponseEntity<List<Alumno>>(body, headers, HttpStatus.OK);

	}
	
}
