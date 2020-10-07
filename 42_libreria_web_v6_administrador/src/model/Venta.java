package model;

import java.util.Date;

public class Venta {
	
	private String titulo;
	private String usuario;
	private Date fecha;
	
	
	public Venta(String titulo, String usuario, Date fecha) {
		super();
		this.titulo = titulo;
		this.usuario = usuario;
		this.fecha = fecha;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
