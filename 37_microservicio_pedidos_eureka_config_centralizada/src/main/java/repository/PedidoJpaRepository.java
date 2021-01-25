package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Pedido;

public interface PedidoJpaRepository extends JpaRepository<Pedido, Integer> {
	
}
