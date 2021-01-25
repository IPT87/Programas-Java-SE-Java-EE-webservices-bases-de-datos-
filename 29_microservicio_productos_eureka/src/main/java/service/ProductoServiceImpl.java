package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Producto;
import repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	ProductoRepository repository;

	@Override
	public List<Producto> todosProductos() {
		return repository.todosProductos();
	}

	@Override
	public double precioProducto(int codigoProducto) {
		return repository.precioProducto(codigoProducto);
	}

	@Override
	public void actualizarStockProducto(int codigoProducto, int unidades) {
		repository.actualizarStockProducto(codigoProducto, unidades);
	}

	@Override
	public void nuevoProducto(Producto producto) {
		repository.nuevoProducto(producto);
	}

}
