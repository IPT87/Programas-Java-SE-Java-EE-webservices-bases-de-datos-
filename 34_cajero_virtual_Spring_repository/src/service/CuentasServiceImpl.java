package service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.Cuenta;
import model.Movimiento;
import repository.CajeroRepository;

@Service
public class CuentasServiceImpl implements CuentasService {
	@Autowired
	CajeroRepository repository;

	@Override
	public List<Cuenta> recuperarCuentas(int dni) {
		return repository.recuperarCuentas(dni);
	}

	@Override
	public boolean verificarCuenta(int numeroCuenta) {
		if (repository.verificarCliente(numeroCuenta) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void ingresar(double cantidad, int numeroCuenta) {
		Cuenta cuenta = repository.verificarCliente(numeroCuenta);
		Movimiento movimiento = new Movimiento(cantidad, Date.from(Instant.now()), "Ingreso", cuenta);
		cuenta.getMovimientos().add(movimiento);
		cuenta.setSaldo(cantidad + saldo(numeroCuenta));
		repository.ingresar(cuenta, movimiento);
	}

	@Override
	public boolean retirar(double cantidad, int numeroCuenta) {
		if (saldo(numeroCuenta) - cantidad < 0) {
			return false;
		} else {
			Cuenta cuenta = repository.verificarCliente(numeroCuenta);
			Movimiento movimiento = new Movimiento(cantidad, Date.from(Instant.now()), "Extraccion", cuenta);
			cuenta.getMovimientos().add(movimiento);
			cuenta.setSaldo(saldo(numeroCuenta) - cantidad);
			repository.sacar(cuenta, movimiento);
			return true;
		}
	}

	@Override
	public List<Movimiento> movimientos(int numeroCuenta) {
		return repository.movimientos(numeroCuenta);
	}

	@Override
	public double saldo(int numeroCuenta) {
		return repository.saldo(numeroCuenta);
	}

	public boolean transferencia(int numCuentaOrigen, int numCuentaDestino, double cantidad) {
		if (saldo(numCuentaOrigen) - cantidad > 0 && repository.verificarCliente(numCuentaDestino) != null) {
			ingresar(cantidad, numCuentaDestino);
			retirar(cantidad, numCuentaOrigen);
			return true;
		} else {
			return false;
		}
	}

}
