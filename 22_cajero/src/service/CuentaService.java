package service;

public class CuentaService {

	private double saldo;
	
	public CuentaService() {
		this.saldo = 0;
	}
	
	public CuentaService(double saldoInicial) {
		this.saldo = saldoInicial;
	}
	
	public void ingresar(double cantidad) {
		this.saldo += cantidad;
	}
	
	public void extraer(double cantidad) {
		if (saldo - cantidad >= 0) {
			this.saldo -= cantidad;
		}
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
}
