package service;

import model.Cliente;

public interface ClientesService {
	Cliente validarCliente(String user, String password);
	boolean registrarCliente(Cliente cliente);
}