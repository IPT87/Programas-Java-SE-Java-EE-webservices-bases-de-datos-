package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.DtoCurso;
import dto.Utilidades;
import model.Curso;
import service.MatriculasService;

@Controller
public class MatriculasRangoController {
	@Autowired
	MatriculasService service;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date fechaInicio = null;
	Date fechaFin = null;
	
	@GetMapping(value = "doConsultarMatriculas", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<DtoCurso> matriculasRango(@RequestParam("fechaInicio") String fechaInicio, @RequestParam("fechaFin") String fechaFin) {
		List<Curso> cursos = service.matriculasRangoFecha(this.fechaInicio, this.fechaFin);
		
		try {
			this.fechaInicio = sdf.parse(fechaInicio);
			this.fechaFin = sdf.parse(fechaFin);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return cursos
				.stream()
				.map(curso -> Utilidades.convertirADtoCurso(curso))
				.collect(Collectors.toList());
	}

}
