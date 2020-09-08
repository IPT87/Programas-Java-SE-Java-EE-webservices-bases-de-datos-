package model;

import java.util.Date;

public class PedidoTienda extends Pedido {
	private String tienda;
	public PedidoTienda(String producto, int unidades, double precioUnitario, String seccion, Date fecha,
			String tienda) {
		super(producto, unidades, precioUnitario, seccion, fecha);
		this.tienda = tienda;
	}

	public String getTienda() {
		return tienda;
	}

	public void setTienda(String tienda) {
		this.tienda = tienda;
	}
	
}