package model;

public class Contacto {
	private int idcontacto;
	private String nombre;
	private String email;
	private int edad;
	
	
	public Contacto(int idcontacto, String nombre, String email, int edad) {
		super();
		this.idcontacto = idcontacto;
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
	}

	public Contacto(String nombre, String email, int edad) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
	}

	public int getIdcontacto() {
		return idcontacto;
	}

	public void setIdcontacto(int idcontacto) {
		this.idcontacto = idcontacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
}
