package controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.DtoAlumno;
import dto.Utilidades;
import service.AlumnosService;

@CrossOrigin(value = "*")
@Controller
public class AlumnosMatricularController {
	@Autowired
	AlumnosService service;
	
	@GetMapping(value = "doSeleccionAlumnoMatricular", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<DtoAlumno> seleccionAlumnoMatricular() {
		
		return service.alumnos()
						.stream()
						.map(alumno -> Utilidades.convertirADtoAlumno(alumno))
						.collect(Collectors.toList()); 
	}

}
