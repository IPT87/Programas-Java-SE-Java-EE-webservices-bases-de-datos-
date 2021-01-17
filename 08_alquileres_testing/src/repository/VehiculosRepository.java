package repository;

import java.util.Date;
import java.util.List;

import model.Vehiculo;

public interface VehiculosRepository {
	Vehiculo altaVehiculo(Vehiculo vehiculo);
	Vehiculo buscarVehiculo(String matricula);
	List<Vehiculo> vehiculosDisponibles(Date fecha);
	List<Vehiculo> totalVehiculos();
}
