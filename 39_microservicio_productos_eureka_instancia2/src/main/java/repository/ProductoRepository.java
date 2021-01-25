package repository;

import java.util.List;

import model.Producto;

public interface ProductoRepository {

	List<Producto> todosProductos();
	double precioProducto(int codigoProducto);
	void actualizarStockProducto(int codigoProducto, int unidades);
	void nuevoProducto(Producto producto);
	
}
