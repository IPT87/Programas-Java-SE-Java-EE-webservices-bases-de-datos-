package model;

public class Pais {
	private String nombre;
	private String capital;
	private double area;
	private long poblacion;
	
	
	public Pais(String nombre, String capital, double area, long poblacion) {
		super();
		this.nombre = nombre;
		this.capital = capital;
		this.area = area;
		this.poblacion = poblacion;
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

	@Override
	public String toString() {
		return "Pais: " + getNombre() + ", capital: " + getCapital() + ", area: " + getArea() + ", poblacion: " + getPoblacion();
	}
	
}
