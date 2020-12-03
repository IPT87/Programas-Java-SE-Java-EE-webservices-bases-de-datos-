package repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import model.Curso;
@Repository("cursosSpringDataJpa")
public class CursosRepositorySpringDataJpaImpl implements CursosRepository {
	@Autowired
	CursosJpaRepository repository;
	
	@Override
	public void altaCurso(Curso curso) {
		repository.save(curso);
		
	}

	@Override
	public Curso cursoPorId(int idCurso) {
		return repository.findById(idCurso).orElse(null);
	}

	@Override
	public List<Curso> todosCursos() {
		return repository.findAll();
	}

	@Override
	public List<Curso> cursosAlumno(String usuario) {
		return repository.findByUsuarioAlumno(usuario);
	}

	@Override
	public List<Curso> cursosDisponiblesAlumno(String usuario) {
		return repository.findCursosNoAlumno(usuario);
	}

	@Override
	public List<Curso> cursosEntreFechas(Date f1, Date f2) {
		return repository.findByFechaInicioBetween(f1, f2);
	}

}
