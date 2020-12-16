package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		String jpql="select i from Inscripcion i ";
		TypedQuery<Inscripcion> query=em.createQuery(jpql,Inscripcion.class);
		return query.getResultList();
	}

	@Override
	public List<String> obtenerEmpresas() {
		String jpql="select distinct i.empresa from Inscripcion i";
		TypedQuery<String> query=em.createQuery(jpql,String.class);
		return query.getResultList();
	}

	@Override
	public List<Inscripcion> obtenerInscripcionesEmpresa(String empresa) {
		String jpql="select i from Inscripcion i where i.empresa=?1";
		TypedQuery<Inscripcion> query=em.createQuery(jpql,Inscripcion.class);
		query.setParameter(1, empresa);
		return query.getResultList();
	}

}
