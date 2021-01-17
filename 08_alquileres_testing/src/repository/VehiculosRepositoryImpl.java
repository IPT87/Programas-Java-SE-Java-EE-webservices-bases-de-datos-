package repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Vehiculo;
@Repository
public class VehiculosRepositoryImpl implements VehiculosRepository {
	@Autowired
	VehiculosJpaRepository repository;
	@Override
	public Vehiculo altaVehiculo(Vehiculo vehiculo) {
		repository.save(vehiculo);
		return vehiculo;
	}

	@Override
	public List<Vehiculo> vehiculosDisponibles(Date fecha) {
		return repository.findVehiculosDisponibles(fecha);
	}

	@Override
	public List<Vehiculo> totalVehiculos() {
		return repository.findAll();
	}

	@Override
	public Vehiculo buscarVehiculo(String matricula) {
		return repository.findById(matricula).orElse(null);
	}

}
