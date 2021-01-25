package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Producto;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {
	@Autowired
	ProductoJpaRepository repository;

	@Override
	public List<Producto> todosProductos() {
		return repository.findAll();
	}

	@Override
	public double precioProducto(int codigoProducto) {
		return repository.findByCodigoProducto(codigoProducto).getPrecioUnitario();
	}

	@Override
	public void actualizarStockProducto(int codigoProducto, int unidades) {
		Producto producto = repository.findById(codigoProducto).orElse(null);
		producto.setStock(producto.getStock() + unidades);
		repository.save(producto);
	}

	@Override
	public void nuevoProducto(Producto producto) {
		repository.save(producto);
	}

}
