package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import model.Alumno;
import repository.AlumnosRepository;
import repository.CursosRepository;

@Service
public class AlumnosServiceImpl implements AlumnosService {
	@Autowired
	@Qualifier("alumnosJpaEstandar")
	AlumnosRepository repository;
	@Autowired
	@Qualifier("cursosJpaEstandar")
	CursosRepository crepository;
	@Override
	public void altaAlumno(Alumno alumno) {
		if(repository.buscarAlumnoPorUsuario(alumno.getUsuario())==null) {
			repository.guardarAlumno(alumno);
		}
		
	}

	@Override
	public Alumno buscarAlumnoPorUsuario(String usuario) {
		return repository.buscarAlumnoPorUsuario(usuario);
	}

	@Override
	public List<Alumno> alumnosCurso(int idCurso) {
		if(crepository.cursoPorId(idCurso)!=null) {
			return repository.alumnosCurso(idCurso);
		}
		return null;
	}

	@Override
	public List<Alumno> alumnos() {
		List<Alumno> todos=repository.todosAlumnos();
		todos.forEach(a->System.out.println("Total de cursos:::::: "+repository.totalCursosAlumno(a.getUsuario())));
		return todos;
	}
	
	
}
