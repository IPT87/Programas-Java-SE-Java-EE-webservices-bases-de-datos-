package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the matriculas database table.
 * 
 */
@Entity
@Table(name="matriculas")
@NamedQuery(name="Matricula.findAll", query="SELECT m FROM Matricula m")
public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MatriculaPK id;

	private double nota;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="usuario", referencedColumnName = "usuario", insertable = false, updatable = false)
	private Alumno alumno;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="idCurso", referencedColumnName = "idCurso", insertable = false, updatable = false)
	private Curso curso;

	public Matricula() {
	}

	public Matricula(MatriculaPK id, double nota) {
		super();
		this.id = id;
		this.nota = nota;
	}

	public MatriculaPK getId() {
		return this.id;
	}

	public void setId(MatriculaPK id) {
		this.id = id;
	}

	public double getNota() {
		return this.nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}