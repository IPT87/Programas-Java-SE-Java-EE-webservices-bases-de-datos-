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
	public void nuevoVehiculo(Vehiculo vehiculo) {
		repository.save(vehiculo);
	}

	@Override
	public void eliminarVehiculo(Vehiculo vehiculo) {
		repository.delete(vehiculo);
	}

	@Override
	public void actualizarVehiculo(Vehiculo vehiculo) {
		repository.save(vehiculo);
	}

	@Override
	public List<Vehiculo> todosVehiculos() {
		return repository.findAll();
	}

	@Override
	public List<Vehiculo> vehiculosDisponibles(Date fechaInicio) {
		return repository.vehiculosDisponibles(fechaInicio);
	}

}
