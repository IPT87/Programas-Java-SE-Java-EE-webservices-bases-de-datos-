package service;

import java.util.List;

import model.Producto;

public interface ProductoService {

	List<Producto> todosProductos();
	double precioProducto(int codigoProducto);
	void actualizarStockProducto(int codigoProducto, int unidades);
	void nuevoProducto(Producto producto);
	
}
