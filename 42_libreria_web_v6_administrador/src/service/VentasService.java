package service;

import java.util.List;

import exceptions.SinLibrosException;
import model.Cliente;
import model.Libro;
import model.Venta;

public interface VentasService {
	
	boolean procesarCompra(Cliente cliente, Libro libro) throws SinLibrosException;
	
	List<Venta> recuperarVentas();
	
}
