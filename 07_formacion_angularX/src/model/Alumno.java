package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the alumnos database table.
 * 
 */
@Entity
@Table(name="alumnos")
@NamedQuery(name="Alumno.findAll", query="SELECT a FROM Alumno a")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String usuario;

	private int edad;

	private String email;

	private String nombre;

	private String password;

	//bi-directional many-to-many association to Curso
	@ManyToMany
	//@JoinColumn(name="usuario")
	//Tabla de union 
	@JoinTable(name = "matriculas",  joinColumns =
	//Join-prop: Alumnos
	           @JoinColumn(name="usuario",referencedColumnName = "usuario"), 
		                             inverseJoinColumns =
	//Join-inv: Cursos
	           @JoinColumn(name="idCurso",referencedColumnName ="idCurso"))	
	private List<Curso> cursos;

	public Alumno() {
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
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

}