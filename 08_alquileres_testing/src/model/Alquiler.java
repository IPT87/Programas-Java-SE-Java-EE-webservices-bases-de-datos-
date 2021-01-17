package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the alquileres database table.
 * 
 */
@Entity
@Table(name = "alquileres")
@NamedQuery(name = "Alquiler.findAll", query = "SELECT a FROM Alquiler a")
public class Alquiler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAlquiler;

	private String emailContacto;

	private double facturacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFin;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicio;

	//bi-directional many-to-one association to Vehiculo
	@ManyToOne
	@JoinColumn(name = "matricula", referencedColumnName = "matricula")
	private Vehiculo vehiculo;

	public Alquiler() {
	}
	
	

	public Alquiler(String emailContacto, double facturacion, Date fechaFin, Date fechaInicio, Vehiculo vehiculo) {
		super();
		this.emailContacto = emailContacto;
		this.facturacion = facturacion;
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
		this.vehiculo = vehiculo;
	}



	public int getIdAlquiler() {
		return this.idAlquiler;
	}

	public void setIdAlquiler(int idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public String getEmailContacto() {
		return this.emailContacto;
	}

	public void setEmailContacto(String emailContacto) {
		this.emailContacto = emailContacto;
	}

	public double getFacturacion() {
		return this.facturacion;
	}

	public void setFacturacion(double facturacion) {
		this.facturacion = facturacion;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}