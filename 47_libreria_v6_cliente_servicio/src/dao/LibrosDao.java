package dao;

import java.util.List;

import model.Libro;

public interface LibrosDao {
	List<Libro> recuperarTodos();
	List<Libro> recuperarPorTema(int idTema);
	Libro recuperarPorIsbn(int isbn);
}
