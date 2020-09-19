package adapter.adaptador;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import adapter.destino.Envio;
import adapter.destino.EnvioImpl;
import adapter.origen.Pedido;

public class AdaptadorPedidoEnvio2 {
	private Pedido pedido;
	
	
	public AdaptadorPedidoEnvio2(Pedido pedido) {
		super();
		this.pedido = pedido;
	}
	
	public Envio getEnvio() {
		return new EnvioImpl(pedido.getProducto(),
					pedido.getPrecioUnitario()*pedido.getUnidades(),
					generarFecha()
					);
	}
	
	private Date generarFecha() {
		LocalDate fEntrega= pedido.getFechaPedido().plusDays(2);
		return Date.from(fEntrega.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
}