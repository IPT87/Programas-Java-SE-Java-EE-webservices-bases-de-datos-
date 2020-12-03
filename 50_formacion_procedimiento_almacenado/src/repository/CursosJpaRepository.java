package repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Curso;

public interface CursosJpaRepository extends JpaRepository<Curso, Integer> {
	@Query("Select c From Curso c join c.alumnos a where a.usuario=?1")
	List<Curso> findByUsuarioAlumno(String usuario);
	
	@Query("Select c From Curso c Where c Not In (Select c From Curso c join c.alumnos a Where a.usuario=?1)")
	List<Curso> findCursosNoAlumno(String usuario);
	
	List<Curso> findByFechaInicioBetween(Date desde, Date hasta);
}
