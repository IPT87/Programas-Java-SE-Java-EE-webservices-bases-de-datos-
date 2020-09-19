package adapter.origen;

import java.time.LocalDate;

public interface Pedido {
	
	String getProducto();
	
	LocalDate getFechaPedido();
	
	int getUnidades();
	
	double getPrecioUnitario();
}
