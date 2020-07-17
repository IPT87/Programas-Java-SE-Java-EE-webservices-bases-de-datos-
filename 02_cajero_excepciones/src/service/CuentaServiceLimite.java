package service;

import exceptions.SaldoNegativoException;

public class CuentaServiceLimite extends CuentaService {

	private double limite;
	
	public CuentaServiceLimite(double limite) {
		super();
		this.limite = limite;
	}
	
	public CuentaServiceLimite(double saldoInicial, double limite) {
		super(saldoInicial);
		this.limite = limite;
	}

	@Override
	public void ingresar(double cantidad) {
		if (cantidad <= limite) {
			super.ingresar(cantidad);
		} else {
			super.ingresar(limite);
		}
	}

	@Override
	public void extraer(double cantidad) throws SaldoNegativoException {
		if (cantidad <= limite) {
			super.extraer(cantidad);
		} else {
			super.extraer(limite);
		}
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
}
