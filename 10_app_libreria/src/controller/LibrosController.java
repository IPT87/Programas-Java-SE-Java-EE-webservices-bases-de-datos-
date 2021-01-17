package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Libro;
import service.LibrosService;

@Controller
public class LibrosController {
	@Autowired
	LibrosService service;
	
	@PostMapping(value = "nuevoLibro")
	public String agregarLibro(@RequestParam("isbn") int isbn, @RequestParam("tematica") String tematica, @RequestParam("titulo") String titulo) {
		service.nuevoLibro(new Libro(isbn, tematica, titulo));
		return "addLibro";
	}
	
	@GetMapping(value = "librosPorTematica", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Libro> librosPorTema(@RequestParam("tema") String tema) {
		List<Libro> libros = service.librosPorTematica(tema);
		
		return libros;
	}
	
	@GetMapping(value = "libroPorIsbn", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Libro libroPorIsbn(@RequestParam("isbn") int isbn) {
		Libro libro = service.libroIsbn(isbn);
		return libro;
	}
	
	@GetMapping(value = "eliminarLibro")
	public String eliminarLibro(@RequestParam("isbn") int isbn, @RequestParam("tematica") String tematica) {
		service.eliminarLibro(isbn);
		service.librosPorTematica(tematica);
		return "librosTematica";
	}
	
	@PostMapping(value = "actualizarLibro")
	public String actualizarLibro(@RequestParam("isbn") int isbn, @RequestParam("tematica") String tematica, @RequestParam("titulo") String titulo) {
		service.actualizarLibro(new Libro(isbn, tematica, titulo));
		return "menu";
	}

}
