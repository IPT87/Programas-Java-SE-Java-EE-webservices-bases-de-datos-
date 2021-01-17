package model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
@JsonIgnoreProperties(allowSetters = true,value = {"alumnos","duracion"})
public class ItemCurso {
	//@JsonProperty(value ="idCurso")
	private int codigoCurso;
	//@JsonProperty(value ="nombre")
	private String nombreCurso;
	private int duracion;
	private ItemAlumno[] alumnos;
	public ItemCurso(int codigoCurso, String nombreCurso, int duracion) {
		super();
		this.codigoCurso = codigoCurso;
		this.nombreCurso = nombreCurso;
		this.duracion = duracion;
	}
	public ItemCurso() {
		super();
	}
	@JsonGetter("codigoCurso")
	public int getCodigoCurso() {
		return codigoCurso;
	}
	@JsonSetter("idCurso")
	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	@JsonGetter("nombreCurso")
	public String getNombreCurso() {
		return nombreCurso;
	}
	@JsonSetter("nombre")
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	public ItemAlumno[] getAlumnos() {
		return alumnos;
	}
	
	public void setAlumnos(ItemAlumno[] alumnos) {
		this.alumnos = alumnos;
	}
	
}
