package controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.DtoAlumno;
import dto.Utilidades;
import service.AlumnosService;

@Controller
public class AlumnosCursoController {
	@Autowired
	AlumnosService service;

	@GetMapping(value = "doAlumnosCurso", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<DtoAlumno> alumnosCurso(@RequestParam("idCurso") int idCurso) {
		
		return service.alumnosCurso(idCurso)
								.stream()
								.map(alumno -> Utilidades.convertirADtoAlumno(alumno))
								.collect(Collectors.toList());
	}
}
