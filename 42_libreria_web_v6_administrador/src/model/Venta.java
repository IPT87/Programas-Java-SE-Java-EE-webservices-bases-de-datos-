package model;

import java.time.LocalDateTime;

public class Venta {
	private Cliente cliente;
	private Libro libro;
	private LocalDateTime fecha;
	public Venta(Cliente cliente, Libro libro, LocalDateTime fecha) {
		super();
		this.cliente = cliente;
		this.libro = libro;
		this.fecha = fecha;
	}
	
	public Venta() {
		super();
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
}
