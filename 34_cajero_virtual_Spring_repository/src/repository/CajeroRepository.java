package repository;

import java.util.List;

import model.Cliente;
import model.Cuenta;
import model.Movimiento;

public interface CajeroRepository {
	
	List<Cliente> recuperarClientes();
	
	List<Cuenta> recuperarCuentas(int dni);
	
	boolean verificarCliente(int numeroCuenta);
	
	void ingresar(double cantidad, int numeroCuenta);
	
	boolean sacar(double cantidad, int numeroCuenta);
	
	List<Movimiento> movimientos(int numeroCuenta);
	
	double saldo(int numeroCuenta);
	
	boolean transferencia(int numCuentaOrigen, int numCuentaDestino, double cantidad);
	
}
