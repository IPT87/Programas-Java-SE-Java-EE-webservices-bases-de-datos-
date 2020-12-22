package dto;

public class DtoFacturacion {

	private String matricula;

	private double facturacion;

	public DtoFacturacion() {
		super();
	}

	public DtoFacturacion(String matricula, double facturacion) {
		super();
		this.matricula = matricula;
		this.facturacion = facturacion;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getFacturacion() {
		return facturacion;
	}

	public void setFacturacion(double facturacion) {
		this.facturacion = facturacion;
	}
	
}
