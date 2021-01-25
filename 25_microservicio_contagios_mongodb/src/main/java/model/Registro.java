package model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "registros")
public class Registro {
	
	@Id
	private String id;
	private String pais;
	private LocalDate fecha;
	private int contagios;
	
	public Registro() {
		super();
	}

	public Registro(String id, String pais, LocalDate fecha, int contagios) {
		super();
		this.id = id;
		this.pais = pais;
		this.fecha = fecha;
		this.contagios = contagios;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getContagios() {
		return contagios;
	}

	public void setContagios(int contagios) {
		this.contagios = contagios;
	}
	
}
