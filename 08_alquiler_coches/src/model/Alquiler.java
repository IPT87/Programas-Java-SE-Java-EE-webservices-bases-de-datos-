package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the alquileres database table.
 * 
 */
@Entity
@Table(name="alquileres")
@NamedQuery(name="Alquiler.findAll", query="SELECT a FROM Alquiler a")
public class Alquiler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAlquiler;
	
	private String matricula;

	private String emailContacto;

	private double facturacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFin;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicio;

	//bi-directional many-to-one association to Vehiculo
	@ManyToOne
	@JoinColumn(name="matricula", referencedColumnName = "matricula", insertable = false, updatable = false)
	private Vehiculo vehiculo;

	public Alquiler() {
	}

	public Alquiler(String matricula, String emailContacto, double facturacion, Date fechaFin, Date fechaInicio) {
		super();
		this.matricula = matricula;
		this.emailContacto = emailContacto;
		this.facturacion = facturacion;
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
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

	public String getMatriculaCoche() {
		return matricula;
	}

	public void setMatriculaCoche(String matricula) {
		this.matricula = matricula;
	}

}