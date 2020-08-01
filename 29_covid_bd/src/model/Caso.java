package model;

import java.util.Date;

public class Caso {
	private String comunidad;
	private Date fecha;
	private int positivos;

	public Caso(String comunidad, Date fecha, int positivos) {
		super();
		this.comunidad = comunidad;
		this.fecha = fecha;
		this.positivos = positivos;
	}

	public String getComunidad() {
		return comunidad;
	}

	public void setComunidad(String comunidad) {
		this.comunidad = comunidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getPositivos() {
		return positivos;
	}

	public void setPositivos(int positivos) {
		this.positivos = positivos;
	}

}