package dto;

import java.util.List;

public class DtoVehiculo {
	
	private String matricula;

	private String color;

	private String marca;

	private String modelo;

	private int potencia;

	private double precioDia;
	
	private List<DtoAlquiler> alquileres;

	public DtoVehiculo() {
		super();
	}

	public DtoVehiculo(String matricula, String color, String marca, String modelo, int potencia, double precioDia,
			List<DtoAlquiler> alquileres) {
		super();
		this.matricula = matricula;
		this.color = color;
		this.marca = marca;
		this.modelo = modelo;
		this.potencia = potencia;
		this.precioDia = precioDia;
		this.alquileres = alquileres;
	}

	public DtoVehiculo(String matricula, String color, String marca, String modelo, int potencia, double precioDia) {
		super();
		this.matricula = matricula;
		this.color = color;
		this.marca = marca;
		this.modelo = modelo;
		this.potencia = potencia;
		this.precioDia = precioDia;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public double getPrecioDia() {
		return precioDia;
	}

	public void setPrecioDia(double precioDia) {
		this.precioDia = precioDia;
	}

	public List<DtoAlquiler> getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(List<DtoAlquiler> alquileres) {
		this.alquileres = alquileres;
	}
	
}
