package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Pedido;
import service.PedidoService;

public class TestPedidoService {
	
	PedidoService service;

	@Before
	public void setUp() throws Exception {
		service = new PedidoService();
	}

	@Test
	public void testAddPedido() {
		service.agregarPedido(new Pedido(12, "Mesa", 89.99));
		service.agregarPedido(new Pedido(6, "Silla", 49.90));
		service.agregarPedido(new Pedido(36, "Boligrafo", 0.99));
		service.agregarPedido(new Pedido(98, "Cuaderno", 1.75));
		service.agregarPedido(new Pedido(11, "Raton inalambrico", 29.99));
		service.agregarPedido(new Pedido(64, "PC", 1200));
		
		assertEquals(service.getPilaPedidos().size(), 6);
	}
	
	@Test
	public void testAddPedidoExistente() {
		service.agregarPedido(new Pedido(12, "Mesa", 89.99));
		service.agregarPedido(new Pedido(6, "Silla", 49.90));
		service.agregarPedido(new Pedido(6, "PC", 1200));
		
		assertEquals(service.getPilaPedidos().size(), 2);
	}
	
	@Test
	public void testProcesarPedido() {
		service.agregarPedido(new Pedido(12, "Mesa", 89.99));
		service.agregarPedido(new Pedido(6, "Silla", 49.90));
		service.agregarPedido(new Pedido(36, "Boligrafo", 0.99));
		service.agregarPedido(new Pedido(98, "Cuaderno", 1.75));
		service.agregarPedido(new Pedido(11, "Raton inalambrico", 29.99));
		
		service.procesarPedido();
		service.procesarPedido();
		service.procesarPedido();
		
		assertEquals(service.getPilaPedidos().size(), 2);
	}
	
	@Test
	public void testProcesarPedidoNoExistente() {
		service.agregarPedido(new Pedido(12, "Mesa", 89.99));
		service.agregarPedido(new Pedido(6, "Silla", 49.90));
		
		service.procesarPedido();
		service.procesarPedido();
		
		assertEquals(service.procesarPedido(), false);
	}
	
	@Test
	public void testPriorizarPedido() {
		service.agregarPedido(new Pedido(12, "Mesa", 89.99));
		service.agregarPedido(new Pedido(6, "Silla", 49.90));
		service.agregarPedido(new Pedido(36, "Boligrafo", 0.99));
		service.agregarPedido(new Pedido(98, "Cuaderno", 1.75));
		service.agregarPedido(new Pedido(11, "Raton inalambrico", 29.99));
		
		service.priorizarPedido(98);
		service.priorizarPedido(98);
		service.priorizarPedido(6);
		
		assertEquals(service.getPilaPedidos().get(2).getProducto(), "Cuaderno");
	}
	
	@Test
	public void testPriorizarPrimerPedido() {
		service.agregarPedido(new Pedido(12, "Mesa", 89.99));
		service.agregarPedido(new Pedido(6, "Silla", 49.90));
		service.agregarPedido(new Pedido(36, "Boligrafo", 0.99));
		service.agregarPedido(new Pedido(98, "Cuaderno", 1.75));
		service.agregarPedido(new Pedido(11, "Raton inalambrico", 29.99));
		
		assertEquals(service.priorizarPedido(12), false);
	}
	
	@Test
	public void testPriorizarPedidoNoExistente() {
		assertEquals(service.priorizarPedido(12), false);
	}
	
	@Test
	public void testFacturacionPedido() {
		service.agregarPedido(new Pedido(12, "Mesa", 89.99));
		service.agregarPedido(new Pedido(6, "Silla", 49.90));
		service.agregarPedido(new Pedido(36, "Boligrafo", 0.99));
		service.agregarPedido(new Pedido(98, "Cuaderno", 1.75));
		service.agregarPedido(new Pedido(11, "Raton inalambrico", 29.99));
		
		assertEquals(service.facturacionPendiente().get(1).getProducto(), "Silla");
	}
	
	@Test
	public void testFacturacionPedidosNoExistentes() {
		assertEquals(service.facturacionPendiente(), null);
	}
	
	@Test
	public void testNombresPedidos() {
		service.agregarPedido(new Pedido(12, "Mesa", 89.99));
		service.agregarPedido(new Pedido(6, "Silla", 49.90));
		service.agregarPedido(new Pedido(36, "Boligrafo", 0.99));
		service.agregarPedido(new Pedido(98, "Cuaderno", 1.75));
		service.agregarPedido(new Pedido(11, "Raton inalambrico", 29.99));
		
		assertEquals(service.nombresPedidosPendientes().get(3), "Cuaderno");
	}
	
	@Test
	public void testNombresPedidosNoExistentes() {
		assertEquals(service.nombresPedidosPendientes(), null);
	}

}
