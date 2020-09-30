package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Libro;

public class LibrosServiceImpl implements LibrosService {

	private static List<Libro> libros;
	
	static {
		libros = new ArrayList<Libro>();
		libros.add(new Libro(111, "Java basico", "programacion"));
		libros.add(new Libro(222, "Python avanzado", "programacion"));
		libros.add(new Libro(333, "HTML", "web"));
		libros.add(new Libro(444, "Cisco", "redes"));
		libros.add(new Libro(555, "JavaScript", "programacion"));
	}
	
	@Override
	public List<Libro> buscarPorTematica(String tematica) {
		return libros
				.stream()
				.filter(l -> l.getTematica().equals(tematica))
				.collect(Collectors.toList());
	}

	@Override
	public Libro buscarLibro(int isbn) {
		return libros
				.stream()
				.filter(l -> l.getIsbn() == isbn)
				.findFirst()
				.orElse(null);
	}

	@Override
	public void eliminarLibro(int isbn) {
		libros.removeIf(l -> l.getIsbn() == isbn);
	}

}
