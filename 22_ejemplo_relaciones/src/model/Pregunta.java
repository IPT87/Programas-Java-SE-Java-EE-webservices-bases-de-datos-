package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the preguntas database table.
 * 
 */
@Entity
@Table(name="preguntas")
@NamedQuery(name="Pregunta.findAll", query="SELECT p FROM Pregunta p")
public class Pregunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPregunta;

	private String enunciado;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	// name es el nombre de la foreign key, es decir, el nombre de la columna relacion
	// en el lado muchos
	// referencedColumnName es el nombre de la primary key en el lado uno
	@JoinColumn(name="idCurso", referencedColumnName = "idCurso")
	private Curso curso;

	public Pregunta() {
	}

	public int getIdPregunta() {
		return this.idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getEnunciado() {
		return this.enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}