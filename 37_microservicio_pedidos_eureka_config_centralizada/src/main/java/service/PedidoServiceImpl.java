package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Pedido;
import repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {
	@Autowired
	PedidoRepository repository;
	@Autowired
	RestTemplate template;
	private String url = "http://servicio-productos/";

	@Override
	public List<Pedido> todosPedidos() {
		return repository.todosPedidos();
	}

	@Override
	public void nuevoPedido(Pedido pedido) {
		Pedido p = pedido;
		double precio = Double.parseDouble(template.getForObject(url + "precio/{codigo}", String.class, pedido.getCodigoProducto()));
		p.setFechaPedido(new Date());
		p.setTotal(pedido.getUnidades() * precio);
		repository.nuevoPedido(p);
		template.put(url + "producto/{codigo}/{unidades}", null, pedido.getCodigoProducto(), pedido.getUnidades());
	}

}
