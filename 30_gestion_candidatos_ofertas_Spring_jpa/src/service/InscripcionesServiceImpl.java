package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Candidato;
import model.Inscripcion;

@Service
public class InscripcionesServiceImpl implements InscripcionesService {
	@PersistenceContext(unitName = "empresaPU")
	EntityManager em;
	
	@Transactional
	@Override
	public void registrarInscripcion(Inscripcion inscripcion) {
		em.persist(inscripcion);
	}

	@Override
	public List<Inscripcion> obtenerInscripciones() {
		TypedQuery<Inscripcion> query = em.createNamedQuery("Inscripcion.findAll", Inscripcion.class);
		return query.getResultList();
	}

	@Override
	public List<Inscripcion> obtenerCandidatosPorEmpresa(String nombreEmpresa) {
		TypedQuery<Inscripcion> query = em.createNamedQuery("Inscripcion.findByNombreEmpresa", Inscripcion.class);
		query.setParameter(1, nombreEmpresa);
		return query.getResultList();
	}

	@Override
	public List<String> obtenerEmpresas() {
		TypedQuery<String> query = em.createNamedQuery("Inscripcion.findByEmpresa", String.class);
		return query.getResultList();
	}

}
