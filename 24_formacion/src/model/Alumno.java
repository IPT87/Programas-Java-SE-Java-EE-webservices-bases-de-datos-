package model;

public class Alumno {
	private int dni;
	private String nombre;
	private String email;
	private int edad;
	private int idCurso;
	
	
	public Alumno(int dni, String nombre, String email, int edad, int idCurso) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
		this.idCurso = idCurso;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	
}
