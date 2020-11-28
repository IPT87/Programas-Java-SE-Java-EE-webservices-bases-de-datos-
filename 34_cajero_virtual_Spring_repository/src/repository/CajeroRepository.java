package repository;

import java.util.List;

import model.Cliente;
import model.Cuenta;
import model.Movimiento;

public interface CajeroRepository {
	
	List<Cliente> recuperarClientes();
	
	List<Cuenta> recuperarCuentas(int dni);
	
	Cuenta verificarCliente(int numeroCuenta);
	
	void ingresar(Cuenta cuenta, Movimiento movimiento);
	
	void sacar(Cuenta cuenta, Movimiento movimiento);
	
	List<Movimiento> movimientos(int numeroCuenta);
	
	double saldo(int numeroCuenta);
	
}
