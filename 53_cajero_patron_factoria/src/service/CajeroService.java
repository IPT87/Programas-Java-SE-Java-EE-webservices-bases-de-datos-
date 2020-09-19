package service;

import java.util.List;

import model.Cuenta;
import model.Movimiento;

public interface CajeroService {

	Cuenta recuperarCuenta(int numeroCuenta);

	void extraer(double cantidad, int numeroCuenta);

	void ingresar(double cantidad, int numeroCuenta);

	double obtenerSaldo(int numeroCuenta);

	List<Movimiento> obtenerMovimientos(int numeroCuenta);

	void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad);

}