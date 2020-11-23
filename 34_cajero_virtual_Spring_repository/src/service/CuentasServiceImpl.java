package service;

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
		return repository.verificarCliente(numeroCuenta);
	}

	@Override
	public void ingresar(double cantidad, int numeroCuenta) {
		repository.ingresar(cantidad, numeroCuenta);
	}

	@Override
	public boolean retirar(double cantidad, int numeroCuenta) {
		return repository.sacar(cantidad, numeroCuenta);
	}

	@Override
	public List<Movimiento> movimientos(int numeroCuenta) {
		return repository.movimientos(numeroCuenta);
	}

	@Override
	public double saldo(int numeroCuenta) {
		return repository.saldo(numeroCuenta);
	}

	@Override
	public boolean transferencia(int numCuentaOrigen, int numCuentaDestino, double cantidad) {
		return repository.transferencia(numCuentaOrigen, numCuentaDestino, cantidad);
	}

}
