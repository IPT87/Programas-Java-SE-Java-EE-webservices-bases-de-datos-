package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Producto;

public interface ProductoJpaRepository extends JpaRepository<Producto, Integer> {
	
	Producto findByCodigoProducto(int codigoProducto);
	
}
