package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import model.Curso;

@Repository
public class CursosRepositoryImpl implements CursosRepository {
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
		return repository.findByAlumno(usuario);
	}

	@Override
	public List<Curso> cursosDisponiblesAlumno(String usuario) {	
		return repository.findDisponiblesByAlumno(usuario);
	}

}
