package service;

import java.util.List;

import model.Pedido;

public interface PedidoService {

	List<Pedido> todosPedidos();
	void nuevoPedido(Pedido pedido);
	
}
