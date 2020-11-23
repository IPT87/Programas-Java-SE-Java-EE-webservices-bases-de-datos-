package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;
import model.Curso;

@Service
public class FormacionServiceImpl implements FormacionService {
	@PersistenceContext(unitName = "formacionPU")
	EntityManager em;

	@Transactional
	@Override
	public void altaAlumno(Alumno alumno) {
		em.persist(alumno);
	}

	@Transactional
	@Override
	public void altaCurso(Curso curso) {
		em.persist(curso);
	}

	@Override
	public Alumno buscarPorUsuario(String usuario) {
		String jpql="SELECT a FROM Alumno a WHERE a.usuario = ?1";

		TypedQuery<Alumno> query = em.createQuery(jpql, Alumno.class);
		query.setParameter(1, usuario);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Alumno> buscarPorCurso(String curso) {
		String jpql="SELECT a FROM Alumno a JOIN a.cursos c WHERE c.nombre = ?1";

		TypedQuery<Alumno> query = em.createQuery(jpql, Alumno.class);
		query.setParameter(1, curso);
		return query.getResultList();
	}

	@Override
	public List<Curso> buscarPorAlumno(String user) {
		String jpql="SELECT c FROM Curso c JOIN c.alumnos a WHERE a.usuario = ?1";

		TypedQuery<Curso> query = em.createQuery(jpql, Curso.class);
		query.setParameter(1, user);
		return query.getResultList();
	}

	@Override
	public List<Alumno> alumnos() {
		TypedQuery<Alumno> query = em.createNamedQuery("Alumno.findAll", Alumno.class);
		return query.getResultList();
	}

	@Transactional
	@Override
	public void asignarAlumnosCursos(String usuario, int idCurso) {
		Alumno alumno = buscarPorUsuario(usuario);
		Curso curso = em.find(Curso.class, idCurso);
		alumno.getCursos().add(curso);
		em.merge(alumno);
	}

	@Override
	public List<Curso> cursosDisponibles(String usuario) {
		String jpql = "SELECT c FROM Curso c WHERE c NOT IN (SELECT c FROM Curso c JOIN c.alumnos a WHERE a.usuario=?1)";
		TypedQuery<Curso> query=em.createQuery(jpql,Curso.class);
		query.setParameter(1, usuario);		
		return query.getResultList();
	}

}
