package service;

import java.util.List;

import exceptions.SinLibrosException;
import model.Cliente;
import model.Libro;

public interface VentasService {
	void nuevaVenta(Cliente cliente,List<Libro> libros) throws SinLibrosException;
}
