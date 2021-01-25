package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Pedido;

@Repository
public class PedidoRepositoryImpl implements PedidoRepository {
	@Autowired
	PedidoJpaRepository repository;

	@Override
	public List<Pedido> todosPedidos() {
		return repository.findAll();
	}

	@Override
	public void nuevoPedido(Pedido pedido) {
		repository.save(pedido);
	}

}
