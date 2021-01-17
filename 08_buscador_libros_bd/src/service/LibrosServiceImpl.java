package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Libro;
import repository.LibrosRepository;

@Service
public class LibrosServiceImpl implements LibrosService {
	@Autowired
	LibrosRepository repository;

	@Override
	public List<Libro> todosLibros() {
		return repository.todosLibros();
	}

	@Override
	public List<Libro> librosPorTematica(String tematica) {
		return repository.librosPorTematica(tematica);
	}

	@Override
	public Libro libroIsbn(int isbn) {
		return repository.libroIsbn(isbn);
	}

	@Override
	public void nuevoLibro(Libro libro) {
		repository.nuevoLibro(libro);;
	}

	@Override
	public void actualizarLibro(Libro libro) {
		repository.actualizarLibro(libro);
	}

	@Override
	public void eliminarLibro(int isbn) {
		repository.eliminarLibro(isbn);;
	}

}
