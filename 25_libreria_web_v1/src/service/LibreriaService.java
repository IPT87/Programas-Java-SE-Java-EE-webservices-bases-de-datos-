package service;

import model.Cliente;

public interface LibreriaService {
	
	Cliente validarCliente(String user, String password);
}
