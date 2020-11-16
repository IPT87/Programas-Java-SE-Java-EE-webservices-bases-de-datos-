package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Alumno;
import model.Curso;

public class FormacionService {
private static EntityManager em;
	
	static {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("formacionPU");
		em = factory.createEntityManager();
	}
	
	public void altaAlumno(Alumno alumno) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(alumno);	
		tx.commit();
	}
	
	public void altaCurso(Curso curso) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(curso);	
		tx.commit();
	}
	
	public Alumno buscarPorUsuario(String usuario) {
		TypedQuery<Alumno> query = em.createNamedQuery("Alumno.findByUsuario", Alumno.class);
		query.setParameter(1, usuario);
		
		try {
			return query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			return null;
		}
	}
	
}
