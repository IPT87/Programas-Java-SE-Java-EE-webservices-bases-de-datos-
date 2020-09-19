package presentacion;

import java.time.LocalDate;

import adapter.adaptador.AdaptadorPedidoEnvio;
import adapter.destino.Envio;
import adapter.origen.Pedido;
import adapter.origen.PedidoImpl;

public class TestAdapter {

	public static void main(String[] args) {
		Pedido pedido=new PedidoImpl("prueba",LocalDate.now(),7,6.3);
		
		Envio adapter=new AdaptadorPedidoEnvio(pedido);
		//obtenemos los datos adaptados
		System.out.println(adapter.getProducto());
		System.out.println(adapter.getPrecio());
		System.out.println(adapter.getFechaEntrega());
	}

}