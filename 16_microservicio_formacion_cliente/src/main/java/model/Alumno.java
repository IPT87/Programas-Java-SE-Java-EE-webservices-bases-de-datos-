package model;

public class Alumno {
	private String usuario;
	private int edad;
	private String email;
	private String nombre;
	private String password;
	
	public Alumno() {
		super();
	}

	public Alumno(String usuario, int edad, String email, String nombre, String password) {
		super();
		this.usuario = usuario;
		this.edad = edad;
		this.email = email;
		this.nombre = nombre;
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}