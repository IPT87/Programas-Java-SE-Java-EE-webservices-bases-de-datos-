package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Curso;

public interface CursosJpaRepository extends JpaRepository<Curso, Integer> {
	
	@Query("SELECT c FROM Curso c JOIN c.alumnos a WHERE a.usuario = ?1")
	List<Curso> findByAlumno(String usuario);
	
	@Query("SELECT c FROM Curso c WHERE c NOT IN (SELECT c FROM Curso c JOIN c.alumnos a WHERE a.usuario = ?1)")
	List<Curso> findDisponiblesByAlumno(String usuario);
	
}
