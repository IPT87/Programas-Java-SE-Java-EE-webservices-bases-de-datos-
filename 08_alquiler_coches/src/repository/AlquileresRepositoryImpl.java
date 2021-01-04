package repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dto.DtoFacturacion;
import model.Alquiler;

@Repository
public class AlquileresRepositoryImpl implements AlquileresRepository {
	@Autowired
	AlquileresJpaRepository repository;

	@Override
	public void nuevoAlquiler(Alquiler alquiler) {
		repository.save(alquiler);
	}

	@Override
	public List<Alquiler> reservas(Date desde, Date hasta) {
		return repository.alquileresPorFecha(desde, hasta);
	}

	@Override
	public List<Alquiler> todosVehiculos() {
		return repository.findAll();
	}

	@Override
	public List<Alquiler> buscarAlquileresPorMatricula(String matricula) {
		return repository.findByMatricula(matricula);
	}

	@Override
	public List<DtoFacturacion> facturacion() {
		return repository.facturacion();
	}

}
