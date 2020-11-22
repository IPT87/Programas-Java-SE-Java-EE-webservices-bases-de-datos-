package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import model.Cliente;

@Service
public class ClientesServiceImpl implements ClientesService {
	@PersistenceContext(unitName = "bancaPU")
	EntityManager em;

	@Override
	public List<Cliente> recuperarClientes() {
		TypedQuery<Cliente> query = em.createNamedQuery("Cliente.findAll", Cliente.class);
		return query.getResultList();
	}

}
