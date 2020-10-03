package service;

import model.Cliente;
import model.Libro;

public interface VentasService {
	boolean procesarCompra(Cliente cliente, Libro libro);
}
