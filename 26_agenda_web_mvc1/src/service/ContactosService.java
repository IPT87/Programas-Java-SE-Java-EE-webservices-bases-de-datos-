package service;

import java.util.List;

import model.Contacto;

public interface ContactosService {

	boolean addContacto(Contacto contacto);

	boolean eliminarContacto(String email);

	Contacto buscarContacto(String email);

	List<Contacto> mostrarContactos();

}