package model;

public class Candidato {
	private int codigoCandidato;
	private String nombre;
	private String puesto;
	private String foto;
	private String email;
	private int edad;
	
	public Candidato(int codigoCandidato, String nombre, String puesto, String foto, String email, int edad) {
		super();
		this.codigoCandidato = codigoCandidato;
		this.nombre = nombre;
		this.puesto = puesto;
		this.foto = foto;
		this.email = email;
		this.edad = edad;
	}
	
	public Candidato() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getCodigoCandidato() {
		return codigoCandidato;
	}

	public void setCodigoCandidato(int codigoCandidato) {
		this.codigoCandidato = codigoCandidato;
	}
	
}
