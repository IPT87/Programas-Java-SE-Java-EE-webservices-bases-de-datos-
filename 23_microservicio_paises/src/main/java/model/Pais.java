package model;

public class Pais {
	private String nombre;
	private String capital;
	private int habitantes;
	private String moneda;
	private String continente;
	
	public Pais() {
		super();
	}

	public Pais(String nombre, String capital, int habitantes, String moneda, String continente) {
		super();
		this.nombre = nombre;
		this.capital = capital;
		this.habitantes = habitantes;
		this.moneda = moneda;
		this.continente = continente;
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

	public int getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}
	
}
