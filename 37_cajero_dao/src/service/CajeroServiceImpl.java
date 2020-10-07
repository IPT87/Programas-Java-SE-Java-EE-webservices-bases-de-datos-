package service;

import java.util.Date;
import java.util.List;

import dao.CajeroDao;
import dao.CajeroDaoFactory;
import model.Cuenta;
import model.Movimiento;

class CajeroServiceImpl implements CajeroService {
	private CajeroDao cd = CajeroDaoFactory.getCajeroDao();
	
	@Override
	public Cuenta recuperarCuenta(int numeroCuenta) {
		return cd.recuperarCuenta(numeroCuenta);
	}

	@Override
	public void extraer(double cantidad, int numeroCuenta) {
		if(cd.recuperarCuenta(numeroCuenta) != null) {
			double nuevoSaldo = cd.recuperarCuenta(numeroCuenta).getSaldo() - cantidad;
			
			if(nuevoSaldo >= 0) {
				cd.actualizarSaldoCuenta(numeroCuenta, nuevoSaldo);
				cd.insertarMovimiento(new Movimiento(0, numeroCuenta, new Date(), cantidad, "Extraccion"));
			}
		}
		
	}

	@Override
	public void ingresar(double cantidad, int numeroCuenta) {
		if(cd.recuperarCuenta(numeroCuenta) != null) {
			double nuevoSaldo = cd.recuperarCuenta(numeroCuenta).getSaldo() + cantidad;
			cd.actualizarSaldoCuenta(numeroCuenta, nuevoSaldo);
			cd.insertarMovimiento(new Movimiento(0, numeroCuenta, new Date(), cantidad, "Ingreso"));
		}
	}

	@Override
	public double obtenerSaldo(int numeroCuenta) {
		return cd.recuperarCuenta(numeroCuenta).getSaldo();
	}

	@Override
	public List<Movimiento> obtenerMovimientos(int numeroCuenta) {
		return cd.recuperarMovimientos(numeroCuenta);
	}

	@Override
	public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) {
		extraer(cantidad, cuentaOrigen);
		ingresar(cantidad, cuentaDestino);
	}
	
}
