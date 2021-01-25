package dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DtoCurso {
	
	private int idCurso;
	private int duracion;	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="Europe/Madrid")
	private Date fechaInicio;
	private String nombre;	
	private List<DtoAlumno> alumnos;

	public DtoCurso() {
		super();
	}

	public DtoCurso(int idCurso, int duracion, Date fechaInicio, String nombre, List<DtoAlumno> alumnos) {
		super();
		this.idCurso = idCurso;
		this.duracion = duracion;
		this.fechaInicio = fechaInicio;
		this.nombre = nombre;
		this.alumnos = alumnos;
	}

	public DtoCurso(int idCurso, int duracion, Date fechaInicio, String nombre) {
		super();
		this.idCurso = idCurso;
		this.duracion = duracion;
		this.fechaInicio = fechaInicio;
		this.nombre = nombre;
		this.alumnos = new ArrayList<DtoAlumno>();
	}

	public int getIdCurso() {
		return idCurso;
	}

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

	public List<DtoAlumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<DtoAlumno> alumnos) {
		this.alumnos = alumnos;
	}
	
}
