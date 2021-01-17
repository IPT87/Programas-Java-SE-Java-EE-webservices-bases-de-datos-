package service;

import java.util.Arrays;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.ItemAlumno;
import model.ItemCurso;
@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	RestTemplate template;
	private String url="http://localhost:8080/cursos";
	@Override
	public List<ItemCurso> cursos() {
		ResponseEntity<ItemCurso[]> respuesta=template.exchange(url, HttpMethod.GET,getEntity("user1","user1"), ItemCurso[].class);
		return Arrays.asList(respuesta.getBody());
		
	}

	@Override
	public List<ItemAlumno> alumnosCurso(int codigo) {
		ItemCurso curso=cursos().stream()
			.filter(c->c.getCodigoCurso()==codigo)
			.findFirst().orElse(null);
		return curso!=null||curso.getAlumnos().length!=0?Arrays.asList(curso.getAlumnos()):null;
	}

	private HttpEntity<String> getEntity(String user, String pwd) {
		String credentials = user+":"+pwd;
		//codificación en BASE64
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));
		HttpHeaders headers = new HttpHeaders();
		//creamos el encabezado autorización con los credenciales en Base64
		headers.add("Authorization", "Basic " + encodedCredentials);
		
		//construimos objeto HttEntity y solicitamos el token al servidor		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
	
		return entity;
	}
	
}
