package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;

@Repository
public class AlumnosRepositoryImpl implements AlumnosRepository {
	@PersistenceContext(unitName = "formacionPU")
	EntityManager em;
	
	@Transactional
	@Override
	public void guardarAlumno(Alumno alumno) {
		em.persist(alumno);
	}

	@Override
	public Alumno buscarAlumnoPorUsuario(String usuario) {
		return em.find(Alumno.class, usuario);
	}

	@Transactional
	@Override
	public void actualizarAlumno(Alumno alumno) {
		em.merge(alumno);
	}

	@Override
	public List<Alumno> alumnosCurso(int idCurso) {
		String jpql = "SELECT a FROM Alumno a JOIN a.cursos c WHERE c.idCurso=?1";
		TypedQuery<Alumno> query=em.createQuery(jpql,Alumno.class);
		query.setParameter(1, idCurso);
		return query.getResultList();
	}

	@Override
	public List<Alumno> todosAlumnos() {
		TypedQuery<Alumno> query=em.createNamedQuery("Alumno.findAll",Alumno.class);
		return query.getResultList();
	}

}
