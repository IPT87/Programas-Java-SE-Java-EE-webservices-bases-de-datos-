package repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Alquiler;
@Repository
public class AlquileresRepositoryImpl implements AlquileresRepository {
	@Autowired
	AlquileresJpaRepository repository;

	@Override
	public Alquiler altaAlquiler(Alquiler alquiler) {
		repository.save(alquiler);
		return alquiler;
	}

	@Override
	public List<Alquiler> alquileresEntreFechas(Date fecha1, Date fecha2) {
		List<Alquiler> alquileres= repository.findAlquilerFechaInicioBetween(fecha1, fecha2);
		return alquileres;
	}

	@Override
	public List<Alquiler> alquileresVechiculo(String matricula) {
		return repository.findAlquilerByVehiculoMatricula(matricula);
	}

	@Override
	public double facturacionVehiculo(String matricula) {
		return repository.facturacionVehiculo(matricula);
	}

}
