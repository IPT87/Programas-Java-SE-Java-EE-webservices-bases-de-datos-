package model;

public class Pais {
	
	private String nombre;
	private String region;
	private String capital;
	private long habitantes;
	private String bandera;
	
	
	public Pais(String nombre, String region, String capital, long habitantes, String bandera) {
		super();
		this.nombre = nombre;
		this.region = region;
		this.capital = capital;
		this.habitantes = habitantes;
		this.bandera = bandera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public long getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(long habitantes) {
		this.habitantes = habitantes;
	}

	public String getBandera() {
		return bandera;
	}

	public void setBandera(String bandera) {
		this.bandera = bandera;
	}
	
}
