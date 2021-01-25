package repository;

import java.util.List;

import model.Pedido;

public interface PedidoRepository {

	List<Pedido> todosPedidos();
	void nuevoPedido(Pedido pedido);

}
