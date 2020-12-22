package dto;

public class DtoVehiculoDiasDisponible {

	private String matricula;
	
	private String marca;

	private String modelo;

	private double precioDia;
	
	private int diasDisponible;
	
	private String color;
	
	private int potencia;

	public DtoVehiculoDiasDisponible() {
		super();
	}

	public DtoVehiculoDiasDisponible(String matricula, String marca, String modelo, String color, int potencia, double precioDia, int diasDisponible) {
		super();
		this.setMatricula(matricula);
		this.marca = marca;
		this.modelo = modelo;
		this.setColor(color);
		this.setPotencia(potencia);
		this.precioDia = precioDia;
		this.diasDisponible = diasDisponible;
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

	public double getPrecioDia() {
		return precioDia;
	}

	public void setPrecioDia(double precioDia) {
		this.precioDia = precioDia;
	}

	public int getDiasDisponible() {
		return diasDisponible;
	}

	public void setDiasDisponible(int diasDisponible) {
		this.diasDisponible = diasDisponible;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
}
