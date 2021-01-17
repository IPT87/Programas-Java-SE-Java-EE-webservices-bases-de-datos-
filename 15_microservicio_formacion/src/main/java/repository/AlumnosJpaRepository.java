package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Alumno;

public interface AlumnosJpaRepository extends JpaRepository<Alumno, String> {
	
	@Query("SELECT a FROM Alumno a JOIN a.cursos c WHERE c.idCurso = ?1")
	public List<Alumno> findByCurso(int idCurso);
	
}
