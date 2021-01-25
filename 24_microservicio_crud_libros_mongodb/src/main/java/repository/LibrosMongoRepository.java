package repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import model.Libro;

public interface LibrosMongoRepository extends MongoRepository<Libro, String> {

	Libro findByIsbn(int isbn);
	
	void deleteByIsbn(int isbn);
	
	List<Libro> findByTematica(String tematica);
	
	@Query("{titulo:{$regex:?0}}")
	List<Libro> findTituloContenido(String cars);
	
}
