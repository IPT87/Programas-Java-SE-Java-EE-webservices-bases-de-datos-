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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import model.Curso;
import service.CursosService;

@Api(value = "Servicio de informacion de cursos en una base de datos.")
@RestController
public class FormacionController {
	@Autowired
	CursosService service;
	
	@ApiOperation(value = "Devuelve la lista de todos los cursos en la base de datos.")
	@GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DtoCurso> cursos() {
		List<DtoCurso> cursos = new ArrayList<>();
		
		service.obtenerCursos()
				.stream()
				.forEach(c -> cursos.add(Utilidades.convertirADtoCurso(c)));
		
		return cursos;
	}
	
	@ApiOperation(value = "Agrega un nuevo curso en la base de datos.")
	@PostMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void agregarCurso(@ApiParam(value = "Los datos del nuevo curso agregado.") @RequestBody Curso curso) {
		service.altaCurso(curso);
	}
	
}
