package dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DtoAlquiler {
	
	private int idAlquiler;

	private String emailContacto;

	private double facturacion;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="America/New_York")
	private Date fechaFin;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="America/New_York")
	private Date fechaInicio;
	
	private DtoVehiculo vehiculo;

	public DtoAlquiler() {
		super();
	}

	public DtoAlquiler(int idAlquiler, String emailContacto, double facturacion, Date fechaFin, Date fechaInicio, DtoVehiculo vehiculo) {
		super();
		this.idAlquiler = idAlquiler;
		this.emailContacto = emailContacto;
		this.facturacion = facturacion;
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
		this.vehiculo = vehiculo;
	}

	public int getIdAlquiler() {
		return idAlquiler;
	}

	public void setIdAlquiler(int idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public String getEmailContacto() {
		return emailContacto;
	}

	public void setEmailContacto(String emailContacto) {
		this.emailContacto = emailContacto;
	}

	public double getFacturacion() {
		return facturacion;
	}

	public void setFacturacion(double facturacion) {
		this.facturacion = facturacion;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public DtoVehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(DtoVehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
}
