package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the candidatos database table.
 * 
 */
@Entity
@Table(name="candidatos")
@NamedQuery(name="Candidato.findAll", query="SELECT c FROM Candidato c")
@NamedQuery(name="Candidato.findByEmpresa", query="SELECT DISTINCT c.empresa FROM Inscripcion c")
public class Candidato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCandidato;

	private int edad;

	private String email;

	private String foto;

	private String nombre;

	private String puesto;

	//bi-directional many-to-one association to Inscripcion
	@OneToMany(mappedBy="candidato", cascade = CascadeType.REMOVE)
	private List<Inscripcion> inscripciones;

	public Candidato() {
	}
	
	public Candidato(int idCandidato, int edad, String email, String foto, String nombre, String puesto) {
		super();
		this.idCandidato = idCandidato;
		this.edad = edad;
		this.email = email;
		this.foto = foto;
		this.nombre = nombre;
		this.puesto = puesto;
	}

	public int getIdCandidato() {
		return this.idCandidato;
	}

	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
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

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPuesto() {
		return this.puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public List<Inscripcion> getInscripciones() {
		return this.inscripciones;
	}

	public void setInscripciones(List<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}

	public Inscripcion addInscripcione(Inscripcion inscripcione) {
		getInscripciones().add(inscripcione);
		inscripcione.setCandidato(this);

		return inscripcione;
	}

	public Inscripcion removeInscripcione(Inscripcion inscripcione) {
		getInscripciones().remove(inscripcione);
		inscripcione.setCandidato(null);

		return inscripcione;
	}

}