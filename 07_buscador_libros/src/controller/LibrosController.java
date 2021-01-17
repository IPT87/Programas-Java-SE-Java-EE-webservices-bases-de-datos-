package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Libro;
import service.LibrosService;

@RestController
public class LibrosController {
	@Autowired
	LibrosService service;
	
	@GetMapping(value = "libros", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Libro> libros() {
		return service.todosLibros();
	}
	
	@GetMapping(value = "libros/{tema}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Libro> librosPorTema(@PathVariable("tema") String tema) {
		return service.librosPorTematica(tema);
	}
	
	@GetMapping(value = "libro/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Libro buscarLibro(@PathVariable("isbn") int isbn) {
		return service.libroIsbn(isbn);
	}
	
	@PostMapping(value = "libro", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void agregar(@RequestBody Libro libro) {
		service.nuevoLibro(libro);
	}
	
	@DeleteMapping(value = "libro/{isbn}")
	public void eliminar(@PathVariable("isbn") int isbn) {
		service.eliminarLibro(isbn);
	}
	
	@PutMapping(value = "libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Libro> modificar(@RequestBody Libro libro) {
		service.actualizarLibro(libro);
		return service.todosLibros();
	}
	
}
