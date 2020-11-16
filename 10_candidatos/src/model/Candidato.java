package model;

public class Candidato {
	private String nombre;
	private int edad;
	private String puesto;
	private String foto;
	
	
	public Candidato(String nombre, int edad, String puesto, String foto) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.puesto = puesto;
		this.foto = foto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
}
