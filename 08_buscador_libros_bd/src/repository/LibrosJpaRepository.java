package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Libro;

public interface LibrosJpaRepository extends JpaRepository<Libro, Integer> {
	
	List<Libro> findByTematica(String tematica);
	Libro findByIsbn(int isbn);
	
}
