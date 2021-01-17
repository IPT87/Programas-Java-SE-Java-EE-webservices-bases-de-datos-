package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vehiculos database table.
 * 
 */
@Entity
@Table(name = "vehiculos")
@NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String matricula;

	private String color;

	private String marca;

	private String modelo;

	private int potencia;

	private double precioDia;

	//bi-directional many-to-one association to Alquiler
	@OneToMany(mappedBy = "vehiculo")
	private List<Alquiler> alquileres;

	public Vehiculo() {
	}
	
	

	public Vehiculo(String matricula, String color, String marca, String modelo, int potencia, double precioDia,
			List<Alquiler> alquileres) {
		super();
		this.matricula = matricula;
		this.color = color;
		this.marca = marca;
		this.modelo = modelo;
		this.potencia = potencia;
		this.precioDia = precioDia;
		this.alquileres = alquileres;
	}



	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPotencia() {
		return this.potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public double getPrecioDia() {
		return this.precioDia;
	}

	public void setPrecioDia(double precioDia) {
		this.precioDia = precioDia;
	}

	public List<Alquiler> getAlquileres() {
		return this.alquileres;
	}

	public void setAlquileres(List<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}

//	public Alquiler addAlquilere(Alquiler alquilere) {
//		getAlquileres().add(alquilere);
//		alquilere.setVehiculo(this);
//
//		return alquilere;
//	}
//
//	public Alquiler removeAlquilere(Alquiler alquilere) {
//		getAlquileres().remove(alquilere);
//		alquilere.setVehiculo(null);
//
//		return alquilere;
//	}

}