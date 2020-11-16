package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Candidato;

/**
 * Session Bean implementation class CandidatosServiceImpl
 */
@Stateless
@LocalBean
public class CandidatosServiceImpl implements CandidatosService {
    @PersistenceContext(unitName = "empresaPU")
	private EntityManager em;
	
	@Override
	public void altaCandidato(Candidato candidato) {
		em.persist(candidato);	
	}
	
	@Override
	public void eliminarCandidato(int idCandidato) {
		Candidato candidato = em.find(Candidato.class, idCandidato);
		
		if(candidato != null) {
			em.remove(candidato);
		}

	}
	
	@Override
	public List<Candidato> recuperarCandidatos() {
		TypedQuery<Candidato> query = em.createNamedQuery("Candidato.findAll", Candidato.class);
		return query.getResultList();
	}
	
	@Override
	public List<Candidato> recuperarCandidatoPuesto(String puesto) {
		TypedQuery<Candidato> query = em.createNamedQuery("Candidato.findByPuesto", Candidato.class);
		query.setParameter(1, puesto);
		return query.getResultList();
	}
	
	@Override
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
	
	@Override
	public void eliminarCandidatoPorEmail(String email) {
		Query query = em.createNamedQuery("Candidato.deleteByEmail");
		query.setParameter(1, email);
		query.executeUpdate();
	}

}
