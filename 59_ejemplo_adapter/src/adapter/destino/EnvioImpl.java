package adapter.destino;

import java.util.Date;

public class EnvioImpl implements Envio {
	private String producto;
	private double precio;
	private Date fechaEntrega;
	
	public EnvioImpl(String producto, double precio, Date fechaEntrega) {
		super();
		this.producto = producto;
		this.precio = precio;
		this.fechaEntrega = fechaEntrega;
	}
	
	public String getProducto() {
		return producto;
	}
	
	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

}
