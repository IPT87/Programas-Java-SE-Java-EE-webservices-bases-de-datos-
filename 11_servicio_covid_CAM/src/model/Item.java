package model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
	private String municipio_distrito;
	@JsonProperty(value = "tasa_incidencia_acumulada_ultimos_14dias")
	private double ia;
	private int casos_confirmados_totales;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd hh:mm:ss")
	private Date fecha_informe;
	
	public Item() {
		super();
	}

	public Item(String municipio_distrito, double ia, int casos_confirmados_totales, Date fecha_informe) {
		super();
		this.municipio_distrito = municipio_distrito;
		this.ia = ia;
		this.casos_confirmados_totales = casos_confirmados_totales;
		this.fecha_informe = fecha_informe;
	}

	public String getMunicipio_distrito() {
		return municipio_distrito;
	}

	public void setMunicipio_distrito(String municipio_distrito) {
		this.municipio_distrito = municipio_distrito;
	}

	public double getIa() {
		return ia;
	}

	public void setIa(double ia) {
		this.ia = ia;
	}

	public int getCasos_confirmados_totales() {
		return casos_confirmados_totales;
	}

	public void setCasos_confirmados_totales(int casos_confirmados_totales) {
		this.casos_confirmados_totales = casos_confirmados_totales;
	}

	public Date getFecha_informe() {
		return fecha_informe;
	}

	public void setFecha_informe(Date fecha_informe) {
		this.fecha_informe = fecha_informe;
	}
	
}
