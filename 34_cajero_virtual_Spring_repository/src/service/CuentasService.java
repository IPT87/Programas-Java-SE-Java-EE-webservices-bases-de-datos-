package service;

import java.util.List;

import model.Cuenta;
import model.Movimiento;

public interface CuentasService {
	
	List<Cuenta> recuperarCuentas(int dni);
	
	boolean verificarCuenta(int numeroCuenta);
	
	void ingresar(double cantidad, int numeroCuenta);
	
	boolean retirar(double cantidad, int numeroCuenta);
	
	List<Movimiento> movimientos(int numeroCuenta);
	
	double saldo(int numeroCuenta);
	
	boolean transferencia(int numCuentaOrigen, int numCuentaDestino, double cantidad);
	
}
