package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Cliente;
import model.Cuenta;

@Service
public class CuentasServiceImpl implements CuentasService {
	@PersistenceContext(unitName = "bancaPU")
	EntityManager em;

	@Transactional
	@Override
	public void asignarCuentasCliente(int numeroCuenta, int dni) {
		Cliente cliente = em.find(Cliente.class, dni);
		Cuenta cuenta = em.find(Cuenta.class, numeroCuenta);
		cliente.getCuentas().add(cuenta);
		em.merge(cliente);
	}

	@Override
	public List<Cuenta> recuperarCuentas(int dni) {
		String jpql="Select c From Cuenta c where c not in (Select distinct c From Cuenta c join c.clientes t Where t.dni=?1)";

		TypedQuery<Cuenta> query = em.createQuery(jpql, Cuenta.class);
		query.setParameter(1, dni);
		return query.getResultList();
	}

}
