package adapter.origen;

import java.time.LocalDate;

public class PedidoImpl implements Pedido {
	private String producto;
	private LocalDate fechaPedido;
	private int unidades;
	private double precioUnitario;
	
	public PedidoImpl(String producto, LocalDate fechaPedido, int unidades, double precioUnitario) {
		super();
		this.producto = producto;
		this.fechaPedido = fechaPedido;
		this.unidades = unidades;
		this.precioUnitario = precioUnitario;
	}
	
	public String getProducto() {
		return producto;
	}
	
	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	public LocalDate getFechaPedido() {
		return fechaPedido;
	}
	
	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	
	public int getUnidades() {
		return unidades;
	}
	
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
}
