package dao;

import java.util.List;

import model.Cliente;
import model.Cuenta;
import model.Movimiento;

public interface CajeroDao {
	
	void insertarMovimiento(Movimiento movimiento);
	
	void actualizarSaldoCuenta(int numeroCuenta, double saldo);
	
	Cuenta recuperarCuenta(int numeroCuenta);
	
	List<Movimiento> recuperarMovimientos(int numeroCuenta);
	
	void insertarCliente(Cliente cliente);
	
}
