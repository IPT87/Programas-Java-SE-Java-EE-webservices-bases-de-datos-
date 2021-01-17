package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Alumno;
import model.Curso;

@Service
public class FormacionServiceImpl implements FormacionService {
	@Autowired
	RestTemplate template;
	private String url = "http://localhost:8080/";

	@Override
	public List<Curso> todosCursos() {
		ResponseEntity<Curso[]> respuesta = template.exchange(url + "cursos", HttpMethod.GET, getEntity("user1", "user1"), Curso[].class);
		return Arrays.asList(respuesta.getBody());
		//Curso[] cursos =  template.getForObject(url + "cursos", Curso[].class);
		// return Arrays.stream(cursos).collect(Collectors.toList());
	}

	@Override
	public List<Alumno> alumnosPorCurso(int idCurso) {
		Curso curso = todosCursos()
						.stream()
						.filter(c -> c.getIdCurso() == idCurso)
						.findFirst().orElse(null);
		
		return curso.getAlumnos().size() != 0 || curso != null ? curso.getAlumnos() : null;
		
		/* Curso[] cursos = template.getForObject(url + "cursos", Curso[].class);
		Curso curso = Arrays.stream(cursos)
							.filter(c -> c.getIdCurso() == idCurso)
							.findFirst().orElse(null);
		return curso.getAlumnos().size() != 0 || curso != null ? curso.getAlumnos() : null; */
	}
	
	private HttpEntity<String> getEntity(String user, String pwd) {
		String credentials = user + ":" + pwd;
		// Codificacion en BASE64
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));
		HttpHeaders headers = new HttpHeaders();
		// Creamos el encabezado autorización con los credenciales en Base64
		headers.add("Authorization", "Basic " + encodedCredentials);
		
		// Construimos objeto HttEntity y solicitamos el token al servidor		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
	
		return entity;
	}

}
