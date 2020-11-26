package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Alumno;
import model.Curso;
import repository.AlumnosRepository;
import repository.CursosRepository;
import repository.MatriculasRepository;

@Service
public class MatriculaServiceImpl implements MatriculasService {
	@Autowired
	CursosRepository cursosRepository;
	@Autowired
	AlumnosRepository alumnosRepository;
	@Autowired
	MatriculasRepository matriculasRepository;
	
	@Override
	public void matricularAlumno(String usuario, int idCurso) {
		Curso curso = cursosRepository.cursoPorId(idCurso);
		Alumno alumno = alumnosRepository.buscarAlumnoPorUsuario(usuario);
		
		if(curso != null && alumno != null) {
			alumno.getCursos().add(curso);
			alumnosRepository.actualizarAlumno(alumno);
		}
	}

	@Override
	public List<Curso> matriculasRangoFecha(Date fechaInicio, Date fechaFin) {
		return matriculasRepository.matriculasRangoFecha(fechaInicio, fechaFin);
	}

}
