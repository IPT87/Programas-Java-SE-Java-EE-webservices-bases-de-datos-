package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the matriculas database table.
 * 
 */
@Embeddable
public class MatriculaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String usuario;

	private int idCurso;

	public MatriculaPK() {
	}
	
	public MatriculaPK(String usuario, int idCurso) {
		super();
		this.usuario = usuario;
		this.idCurso = idCurso;
	}

	public String getUsuario() {
		return this.usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public int getIdCurso() {
		return this.idCurso;
	}
	
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MatriculaPK)) {
			return false;
		}
		MatriculaPK castOther = (MatriculaPK)other;
		return 
			this.usuario.equals(castOther.usuario)
			&& (this.idCurso == castOther.idCurso);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.usuario.hashCode();
		hash = hash * prime + this.idCurso;
		
		return hash;
	}
}