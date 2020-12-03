package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import model.Alumno;

@Repository("alumnosSpringDataJpa")
public class AlumnosRepositorySpringDataJpaImpl implements AlumnosRepository {
	@Autowired
	AlumnosJpaRepository repository;
	
	
	@Override
	public void guardarAlumno(Alumno alumno) {
		repository.save(alumno);
	}

	@Override
	public Alumno buscarAlumnoPorUsuario(String usuario) {
		//return repository.findById(usuario).orElse(null);
		return repository.findAlumno(usuario);
	}
	
	@Override
	public void actualizarAlumno(Alumno alumno) {
		repository.save(alumno);
	}

	@Override
	public List<Alumno> alumnosCurso(int idCurso) {
		
		return repository.findByIdCurso(idCurso);
	}

	@Override
	public List<Alumno> todosAlumnos() {
		return repository.findAll();
	}

	@Override
	public int totalCursosAlumno(String usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

}
