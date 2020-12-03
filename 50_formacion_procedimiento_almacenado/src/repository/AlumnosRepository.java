package repository;

import java.util.List;

import model.Alumno;

public interface AlumnosRepository {
	void guardarAlumno(Alumno alumno);
	Alumno buscarAlumnoPorUsuario(String usuario);
	void actualizarAlumno(Alumno alumno);
	List<Alumno> alumnosCurso(int idCurso);
	List<Alumno> todosAlumnos();
	int totalCursosAlumno(String usuario);
}
