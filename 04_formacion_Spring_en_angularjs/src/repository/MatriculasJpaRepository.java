package repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Curso;

public interface MatriculasJpaRepository extends JpaRepository<Curso, Integer> {
	
	@Query("SELECT c FROM Curso c WHERE c.fechaInicio >= ?1 AND c.fechaInicio <= ?2")
	List<Curso> findByFechaInicioBetween(Date desde, Date hasta);
	
}
