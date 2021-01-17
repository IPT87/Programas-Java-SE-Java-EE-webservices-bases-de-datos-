package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import model.Libro;

@Service
public class LibrosServiceImpl implements LibrosService {

	private List<Libro> libros;
	
	public LibrosServiceImpl() {
		libros = new ArrayList<>();
		libros.add(new Libro(1111, "Microservicios Spring Boot", "Web"));
		libros.add(new Libro(2222, "Java EE", "Programación"));
		libros.add(new Libro(3333, "Python básico", "Programación"));
		libros.add(new Libro(4444, "Cisco", "Redes"));
	}

	@Override
	public List<Libro> todosLibros() {
		return libros;
	}

	@Override
	public List<Libro> librosPorTematica(String tematica) {
		return libros
				.stream()
				.filter(l -> l.getTematica().equals(tematica))
				.collect(Collectors.toList());
	}

	@Override
	public Libro libroIsbn(int isbn) {
		return libros
				.stream()
				.filter(l -> l.getIsbn() == isbn)
				.findFirst()
				.orElse(null);
	}

	@Override
	public void nuevoLibro(Libro libro) {
		libros.add(libro);
	}

	@Override
	public void actualizarLibro(Libro libro) {
		// Si encontramos un libro con el isbn del recibido, lo sustituimos
		for (int i = 0; i < libros.size(); i++) {
			if (libros.get(i).getIsbn() == libro.getIsbn()) {
				libros.set(i, libro);
				return;
			}
		}
	}

	@Override
	public void eliminarLibro(int isbn) {
		libros.removeIf(l -> l.getIsbn() == isbn);
	}

}
