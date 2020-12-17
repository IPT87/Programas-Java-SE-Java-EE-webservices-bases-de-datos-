package dto;

import java.util.ArrayList;
import java.util.stream.Collectors;

import model.Alumno;
import model.Curso;

public class Utilidades {
	
	public static DtoAlumno convertirADtoAlumno (Alumno alumno) {
		return new DtoAlumno(alumno.getUsuario(),
							 alumno.getEdad(),
							 alumno.getEmail(),
							 alumno.getNombre(),
							 alumno.getPassword());
	}
	
	public static DtoCurso convertirADtoCurso (Curso curso) {
		return new DtoCurso(curso.getIdCurso(),
							curso.getDuracion(),
							curso.getFechaInicio(),
							curso.getNombre(),
							curso.getAlumnos() == null ? new ArrayList<DtoAlumno>() : curso.getAlumnos()
																								.stream()
																								.map(alumno -> convertirADtoAlumno(alumno))
																								.collect(Collectors.toList()));
	}
}
