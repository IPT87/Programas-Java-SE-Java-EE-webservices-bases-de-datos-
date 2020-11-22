package service;

import java.util.List;

import model.Cuenta;

public interface CuentasService {
	
	void asignarCuentasCliente(int numeroCuenta, int dni);
	
	List<Cuenta> recuperarCuentas(int dni);
	
}
