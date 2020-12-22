package service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.DtoFacturacion;
import model.Alquiler;
import repository.AlquileresRepository;

@Service
public class AlquileresServiceImpl implements AlquileresService {
	@Autowired
	AlquileresRepository repository;

	@Override
	public void nuevoAlquiler(Alquiler alquiler) {
		repository.nuevoAlquiler(alquiler);
	}

	@Override
	public List<Alquiler> reservas(Date desde, Date hasta) {
		return repository.reservas(desde, hasta);
	}

	@Override
	public List<DtoFacturacion> facturacion() {
		return repository.facturacion();
	}

}
