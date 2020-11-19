package model;

public class Inscripcion {
	private int idInscripcion;
	private String empresa;
	private String posicion;
	private double salario;
	private Candidato candidato;
	
	
	public Inscripcion(int idInscripcion, String empresa, String posicion, double salario, Candidato candidato) {
		super();
		this.idInscripcion = idInscripcion;
		this.empresa = empresa;
		this.posicion = posicion;
		this.salario = salario;
		this.candidato = candidato;
	}

	public int getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
}
