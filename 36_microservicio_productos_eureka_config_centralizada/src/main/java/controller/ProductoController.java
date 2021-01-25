package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Producto;
import service.ProductoService;

@CrossOrigin("*")
@RestController
public class ProductoController {
	@Autowired
	ProductoService service;
	
	@GetMapping(value = "productos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> productos() {
		return service.todosProductos();
	}
	
	@GetMapping(value = "precio/{codigo}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String precio(@PathVariable("codigo") int codigo) {
		return service.precioProducto(codigo) + "";
	}
	
	@PutMapping(value = "producto/{codigo}/{unidades}")
	public void modificar(@PathVariable("codigo") int codigo, @PathVariable("unidades") int unidades) {
		service.actualizarStockProducto(codigo, unidades);
	}
	
	@PostMapping(value = "producto", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void agregar(@RequestBody Producto producto) {
		service.nuevoProducto(producto);
	}

}
