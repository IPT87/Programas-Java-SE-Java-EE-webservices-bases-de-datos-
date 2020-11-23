package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Alumno;
import model.Curso;
import repository.AlumnosRepository;
import repository.CursosRepository;

@Service
public class MatriculaServiceImpl implements MatriculasService {
	@Autowired
	CursosRepository cursosRepository;
	@Autowired
	AlumnosRepository alumnosRepository;
	
	@Override
	public void matricularAlumno(String usuario, int idCurso) {
		Curso curso = cursosRepository.cursoPorId(idCurso);
		Alumno alumno = alumnosRepository.buscarAlumnoPorUsuario(usuario);
		
		if(curso != null && alumno != null) {
			alumno.getCursos().add(curso);
			alumnosRepository.actualizarAlumno(alumno);
		}
	}

}
