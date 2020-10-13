package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Movimiento {
	private int idMovimiento;
	private int idCuenta;
	private Date fecha;
	private double cantidad;
	private String operacion;
	public Movimiento(int idMovimiento, int idCuenta, Date fecha, double cantidad, String operacion) {
		super();
		this.idMovimiento = idMovimiento;
		this.idCuenta = idCuenta;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.operacion = operacion;
	}
	public int getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public int getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
		return "Usted realizo " + getOperacion() + " de " + getCantidad() + "€" + " el dia " + sdt.format(getFecha()) + ".";
	}
	
}
