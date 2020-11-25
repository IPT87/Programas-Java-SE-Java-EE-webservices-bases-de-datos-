package repository;

import java.time.Instant;
import java.util.Date;
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
	public boolean verificarCliente(int numeroCuenta) {
		if (em.find(Cuenta.class, numeroCuenta) != null) {
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public void ingresar(double cantidad, int numeroCuenta) {
		Cuenta cuenta = em.find(Cuenta.class, numeroCuenta);
		Movimiento movimiento = new Movimiento(cantidad, Date.from(Instant.now()), "Ingreso", cuenta);
		cuenta.getMovimientos().add(movimiento);
		cuenta.setSaldo(cantidad + saldo(numeroCuenta));
		em.merge(cuenta);
		em.persist(movimiento);
	}

	@Transactional
	@Override
	public boolean sacar(double cantidad, int numeroCuenta) {
		if (saldo(numeroCuenta) - cantidad < 0) {
			return false;
		} else {
			Cuenta cuenta = em.find(Cuenta.class, numeroCuenta);
			Movimiento movimiento = new Movimiento(cantidad, Date.from(Instant.now()), "Extraccion", cuenta);
			cuenta.getMovimientos().add(movimiento);
			cuenta.setSaldo(saldo(numeroCuenta) - cantidad);
			em.merge(cuenta);
			em.persist(movimiento);
			return true;
		}
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

	@Transactional
	@Override
	public boolean transferencia(int numCuentaOrigen, int numCuentaDestino, double cantidad) {
		if (saldo(numCuentaOrigen) - cantidad > 0 && verificarCliente(numCuentaDestino)) {
			ingresar(cantidad, numCuentaDestino);
			sacar(cantidad, numCuentaOrigen);
			return true;
		} else {
			return false;
		}
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
