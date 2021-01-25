package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Alumno;
import model.Curso;

@Service
public class FormacionServiceImpl implements FormacionService {
	@Autowired
	RestTemplate template;
	private String url = "http://servicio-formacion/";

	@Override
	public List<Curso> todosCursos() {
		Curso[] cursos = template.getForObject(url + "cursos", Curso[].class);
		return Arrays.stream(cursos).collect(Collectors.toList());
	}

	@Override
	public List<Alumno> alumnosPorCurso(int idCurso) {
		Curso[] cursos = template.getForObject(url + "cursos", Curso[].class);
		Curso curso = Arrays.stream(cursos)
							.filter(c -> c.getIdCurso() == idCurso)
							.findFirst().orElse(null);
		return curso.getAlumnos().size() != 0 || curso != null ? curso.getAlumnos() : null;
	}

}
