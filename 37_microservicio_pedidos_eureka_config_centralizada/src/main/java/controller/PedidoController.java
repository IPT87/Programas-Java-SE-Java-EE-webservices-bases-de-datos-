package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Pedido;
import service.PedidoService;

@CrossOrigin("*")
@RestController
public class PedidoController {
	@Autowired
	PedidoService service;
	
	@GetMapping(value = "pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> productos() {
		return service.todosPedidos();
	}
	
	@PostMapping(value = "pedido", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void agregar(@RequestBody Pedido pedido) {
		service.nuevoPedido(pedido);
	}

}
