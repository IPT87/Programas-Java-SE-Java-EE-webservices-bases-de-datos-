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
		Date inicio = new Date(desde.getTime() + (3_600_000 * 24));
		Date fin = new Date(hasta.getTime() + (3_600_000 * 24));
		System.out.println(inicio);
		System.out.println(fin);
		return repository.reservas(inicio, fin);
	}

	@Override
	public List<DtoFacturacion> facturacion() {
		return repository.facturacion();
	}

}
