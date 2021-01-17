package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import model.Libro;
import service.LibrosService;

@Api(value = "Servicio de informacion de libros en una base de datos.")
@RestController
public class LibrosController {
	@Autowired
	LibrosService service;
	
	@ApiOperation(value = "Devuelve la lista de todos los libros en la base de datos.")
	@GetMapping(value = "libros", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Libro> libros() {
		return service.todosLibros();
	}
	
	@ApiOperation(value = "Devuelve la lista de libros por un tema especificado.")
	@GetMapping(value = "libros/{tema}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Libro>> librosPorTema(@ApiParam(value = "Tema como criterio de busqueda.") @PathVariable("tema") String tema) {
		List<Libro> libros = service.librosPorTematica(tema);
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalLibros", libros.size() + "");
		return new ResponseEntity<List<Libro>>(libros, headers, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Devuelve un libro por su ISBN.")
	@GetMapping(value = "libro/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Libro> buscarLibro(@ApiParam(value = "ISBN como criterio de busqueda.") @PathVariable("isbn") int isbn) {
		Libro libro = service.libroIsbn(isbn);
		return libro == null ? new ResponseEntity<Libro>(null, null, HttpStatus.BAD_REQUEST) : new ResponseEntity<Libro>(libro, null, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Agrega un nuevo libro en la base de datos.")
	@PostMapping(value = "libro", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void agregar(@ApiParam(value = "Los datos del nuevo libro agregado.") @RequestBody Libro libro) {
		service.nuevoLibro(libro);
	}
	
	@ApiOperation(value = "Elimina de la base de datos un libro con un ISBN especificado.")
	@DeleteMapping(value = "libro/{isbn}")
	public void eliminar(@ApiParam(value = "ISBN como criterio de eliminacion.") @PathVariable("isbn") int isbn) {
		service.eliminarLibro(isbn);
	}
	
	@ApiOperation(value = "Modifica los datos de un libro especifico.")
	@PutMapping(value = "libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Libro> modificar(@ApiParam(value = "Los nuevos datos del libro modificado.") @RequestBody Libro libro) {
		service.actualizarLibro(libro);
		return service.todosLibros();
	}
	
}
