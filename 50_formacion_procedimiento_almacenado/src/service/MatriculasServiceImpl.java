package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import model.Alumno;
import model.Curso;
import repository.AlumnosRepository;
import repository.CursosRepository;

@Service
public class MatriculasServiceImpl implements MatriculasService {
	@Autowired
	@Qualifier("cursosJpaEstandar")
	CursosRepository cursosRepository;
	@Autowired
	@Qualifier("alumnosJpaEstandar")
	AlumnosRepository alumnosRepository;
	@Override
	public void matricularAlumno(String usuario, int idCurso) {
		Curso curso=cursosRepository.cursoPorId(idCurso);
		Alumno alumno=alumnosRepository.buscarAlumnoPorUsuario(usuario);
		if(alumno!=null&&curso!=null) {
			alumno.getCursos().add(curso);
			alumnosRepository.actualizarAlumno(alumno);	
		}
	}
	@Override
	public List<Curso> consultarMatriculas(String f1, String f2) {
		List<Curso> cursos=null;
		try {
			Date fIni = (new SimpleDateFormat("yyyy-MM-dd")).parse(f1);
			Date fFin=(new SimpleDateFormat("yyyy-MM-dd")).parse(f2);
			if(fIni.before(fFin)) {
				cursos= cursosRepository.cursosEntreFechas(fIni, fFin);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return cursos;
	}

}
