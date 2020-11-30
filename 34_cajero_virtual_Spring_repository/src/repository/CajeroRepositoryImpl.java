package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Cliente;
import model.Cuenta;
import model.Movimiento;

@Repository
public class CajeroRepositoryImpl implements CajeroRepository {
	@PersistenceContext(unitName = "bancaPU")
	EntityManager em;

	@Override
	public Cuenta verificarCliente(int numeroCuenta) {
		return em.find(Cuenta.class, numeroCuenta);
	}

	@Transactional
	@Override
	public void ingresar(Cuenta cuenta, Movimiento movimiento) {
		em.merge(cuenta);
		em.persist(movimiento);
	}

	@Transactional
	@Override
	public void sacar(Cuenta cuenta, Movimiento movimiento) {
		em.merge(cuenta);
		em.persist(movimiento);
	}

	@Override
	public List<Movimiento> movimientos(int numeroCuenta) {
		String jpql = "SELECT m FROM Movimiento m WHERE m.cuenta.numeroCuenta = ?1";
		TypedQuery<Movimiento> query = em.createQuery(jpql, Movimiento.class);
		query.setParameter(1, numeroCuenta);
		return query.getResultList();
	}

	@Override
	public double saldo(int numeroCuenta) {
		String jpql = "SELECT c.saldo FROM Cuenta c WHERE c.numeroCuenta = ?1";
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		query.setParameter(1, numeroCuenta);
		return query.getSingleResult();
	}

	@Override
	public List<Cliente> recuperarClientes() {
		TypedQuery<Cliente> query = em.createNamedQuery("Cliente.findAll", Cliente.class);
		return query.getResultList();
	}

	@Override
	public List<Cuenta> recuperarCuentas(int dni) {
		String jpql = "SELECT c FROM Cuenta c JOIN c.clientes cl WHERE cl.dni = ?1";
		TypedQuery<Cuenta> query = em.createQuery(jpql, Cuenta.class);
		query.setParameter(1, dni);
		return query.getResultList();
	}

}
