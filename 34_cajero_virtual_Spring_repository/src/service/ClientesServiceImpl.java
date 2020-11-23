package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Cliente;
import repository.CajeroRepository;

@Service
public class ClientesServiceImpl implements ClientesService {
	@Autowired
	CajeroRepository repository;

	@Override
	public List<Cliente> recuperarClientes() {
		return repository.recuperarClientes();
	}

}
