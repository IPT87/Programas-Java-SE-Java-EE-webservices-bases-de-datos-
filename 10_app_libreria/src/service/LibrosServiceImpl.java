package service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Libro;

@Service
public class LibrosServiceImpl implements LibrosService {
	@Autowired
	RestTemplate template;
	// private String url = "http://localhost:8080/08_buscador_libros_bd/";
	private String url = "http://localhost:8000/";
	
	@Override
	public void nuevoLibro(Libro libro) {
		template.postForLocation(url + "libro", libro);
	}

	@Override
	public List<Libro> librosPorTematica(String tematica) {
		Libro[] libros = template.getForObject(url + "libros/{tema}", Libro[].class, tematica);
		return Arrays.asList(libros);
		// Si nos hubiera interesado tambien la cabecera:
		/* ResponseEntity<Libro[]> respuesta = template.getForEntity(url + "libros/{tema}", Libro[].class, tematica);
		HttpHeaders encabezados = respuesta.getHeaders();
		System.out.println(encabezados.get("total"));
		return Arrays.asList(respuesta.getBody()); */
	}

	@Override
	public void actualizarLibro(Libro libro) {
		template.put(url + "libro", libro);
	}

	@Override
	public void eliminarLibro(int isbn) {
		template.delete(url + "libro/{isbn}", isbn);
	}

	@Override
	public Libro libroIsbn(int isbn) {
		Libro libro = template.getForObject(url + "libro/{isbn}", Libro.class, isbn);
		return libro;
		// Por si quieremos tener acceso a la cabecera y el cuerpo
		/* ResponseEntity<Libro> respuesta = template.getForEntity(url + "libro/{isbn}", Libro.class, isbn);
		return.respuesta.getBody(); */
	}

}
