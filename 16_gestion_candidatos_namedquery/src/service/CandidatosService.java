package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Candidato;

public class CandidatosService {
	private static EntityManager em;
	
	static {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("empresaPU");
		em = factory.createEntityManager();
	}
	
	public void altaCandidato(Candidato candidato) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(candidato);	
		tx.commit();
	}
	
	public void eliminarCandidato(int idCandidato) {
		Candidato candidato = em.find(Candidato.class, idCandidato);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		if(candidato != null) {
			em.remove(candidato);
		}
		tx.commit();
	}
	
	public List<Candidato> recuperarCandidatos() {
		TypedQuery<Candidato> query = em.createNamedQuery("Candidato.findAll", Candidato.class);
		return query.getResultList();
	}
	
	public List<Candidato> recuperarCandidatoPuesto(String puesto) {
		TypedQuery<Candidato> query = em.createNamedQuery("Candidato.findByPuesto", Candidato.class);
		query.setParameter(1, puesto);
		return query.getResultList();
	}
	
	public Candidato buscarPorEmail(String email) {
		TypedQuery<Candidato> query = em.createNamedQuery("Candidato.findByEmail", Candidato.class);
		query.setParameter(1, email);
		//return query.getResultList().stream().findFirst().orElse(null);
		
		try {
			return query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			return null;
		}
	}
	
	public void eliminarCandidatoPorEmail(String email) {
		EntityTransaction tx = em.getTransaction();
		tx.begin(); // iniciamos tx siempre que sea consulta de accion
		Query query = em.createNamedQuery("Candidato.deleteByEmail");
		query.setParameter(1, email);
		query.executeUpdate();
		tx.commit();
	}
	
}
