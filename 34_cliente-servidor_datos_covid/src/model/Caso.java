package model;

import java.io.Serializable;
import java.util.Date;

public class Caso implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombreComunidad;
	private Date fecha;
	private long positivos;

	public Caso(String nombreComunidad, Date fecha, long positivos) {
		super();
		this.nombreComunidad = nombreComunidad;
		this.fecha = fecha;
		this.positivos = positivos;
	}

	public String getNombreComunidad() {
		return nombreComunidad;
	}

	public void setNombreComunidad(String nombreComunidad) {
		this.nombreComunidad = nombreComunidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public long getPositivos() {
		return positivos;
	}

	public void setPositivos(int positivos) {
		this.positivos = positivos;
	}

}
