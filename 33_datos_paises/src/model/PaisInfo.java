package model;

import org.json.simple.JSONArray;

public class PaisInfo {
	private String region;
	private String nombre;
	private String capital;
	private String alpha2Code;
	private JSONArray coordenadas;
	private double area;
	private long poblacion;
	
	
	public PaisInfo(String region, String nombre, String capital, String alpha2Code, JSONArray coordenadas, double area,
			long poblacion) {
		super();
		this.region = region;
		this.nombre = nombre;
		this.capital = capital;
		this.alpha2Code = alpha2Code;
		this.coordenadas = coordenadas;
		this.area = area;
		this.poblacion = poblacion;
	}


	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getAlpha2Code() {
		return alpha2Code;
	}

	public void setAlpha2Code(String alpha2Code) {
		this.alpha2Code = alpha2Code;
	}

	public JSONArray getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(JSONArray coordenadas) {
		this.coordenadas = coordenadas;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public long getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(long poblacion) {
		this.poblacion = poblacion;
	}
	
}
