package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Libro;

@Repository
public class LibrosRepositoryImpl implements LibrosRepository {
	@Autowired
	LibrosJpaRepository repository;

	@Override
	public List<Libro> todosLibros() {
		return repository.findAll();
	}

	@Override
	public List<Libro> librosPorTematica(String tematica) {
		return repository.findByTematica(tematica);
	}

	@Override
	public Libro libroIsbn(int isbn) {
		return repository.findByIsbn(isbn);
	}

	@Override
	public void nuevoLibro(Libro libro) {
		repository.save(libro);
	}

	@Override
	public void actualizarLibro(Libro libro) {
		repository.save(libro);
	}

	@Override
	public void eliminarLibro(int isbn) {
		List<Libro> libros = todosLibros();
		
		for (Libro l : libros) {
			if (l.getIsbn() == isbn) {
				repository.delete(l);
				return;
			}
		}
		
	}

}
