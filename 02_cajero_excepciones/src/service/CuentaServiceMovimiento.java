package service;

import java.util.ArrayList;

import exceptions.SaldoNegativoException;
import model.Movimiento;

public class CuentaServiceMovimiento extends CuentaServiceLimite {
	
	private ArrayList<Movimiento> listaMovimientos;

	public CuentaServiceMovimiento(double saldoInicial, double limite) {
		super(saldoInicial, limite);
		listaMovimientos = new ArrayList<>();
	}

	public CuentaServiceMovimiento(double limite) {
		super(limite);
		listaMovimientos = new ArrayList<>();
	}

	@Override
	public void ingresar(double cantidad) {
		super.ingresar(cantidad);
		Movimiento movimiento = new Movimiento(cantidad > this.getLimite() ? this.getLimite() : cantidad, "Ingresar");
		listaMovimientos.add(movimiento);
	}

	@Override
	public void extraer(double cantidad) throws SaldoNegativoException {
		super.extraer(cantidad);
		Movimiento movimiento = new Movimiento(cantidad > this.getLimite() ? this.getLimite() : cantidad, "Extraer");
		listaMovimientos.add(movimiento);
	}

	public ArrayList<Movimiento> getLista() {
		return listaMovimientos;
	}

	public void setLista(ArrayList<Movimiento> lista) {
		this.listaMovimientos = lista;
	}
	
}
