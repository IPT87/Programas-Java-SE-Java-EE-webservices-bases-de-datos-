package adapter.adaptador;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import adapter.destino.Envio;
import adapter.origen.Pedido;

public class AdaptadorPedidoEnvio implements Envio {
	private Pedido pedido;
	
	
	public AdaptadorPedidoEnvio(Pedido pedido) {
		super();
		this.pedido = pedido;
	}

	@Override
	public String getProducto() {
		return pedido.getProducto();
	}

	@Override
	public double getPrecio() {
		
		return pedido.getUnidades()*pedido.getPrecioUnitario();
	}

	@Override
	public Date getFechaEntrega() {
		LocalDate fEntrega= pedido.getFechaPedido().plusDays(2);
		return Date.from(fEntrega.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

}
