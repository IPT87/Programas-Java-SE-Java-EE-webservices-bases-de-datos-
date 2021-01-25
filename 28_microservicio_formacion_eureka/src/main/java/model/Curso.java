package model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(allowSetters = true, value = {"alumnos"})
public class Curso {
	// @JsonProperty(value = "idCurso")
	private int idCurso;
	private int duracion;	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="Europe/Madrid")
	private Date fechaInicio;
	private String nombre;	
	private List<Alumno> alumnos;
	
	public Curso() {
		super();
	}

	public Curso(int idCurso, int duracion, Date fechaInicio, String nombre, List<Alumno> alumnos) {
		super();
		this.idCurso = idCurso;
		this.duracion = duracion;
		this.fechaInicio = fechaInicio;
		this.nombre = nombre;
		this.alumnos = alumnos;
	}

	// @JsonGetter("codigoCurso")
	public int getIdCurso() {
		return idCurso;
	}

	// @JsonSetter("idCurso")
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// @JsonIgnore
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
}
