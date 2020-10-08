package service;

import java.util.List;

import exceptions.SinLibrosException;
import model.Cliente;
import model.Libro;
import model.Venta;

public interface VentasService {
	void nuevaVenta(Cliente cliente,List<Libro> libros) throws SinLibrosException;
	List<Venta> obtenerVentas();
	List<Venta> obtenerVentasPorPagina(int numeroPagina);
	int paginasVentas();
}