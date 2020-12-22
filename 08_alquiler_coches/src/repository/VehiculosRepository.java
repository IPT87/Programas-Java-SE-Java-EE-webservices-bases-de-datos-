package repository;

import java.util.Date;
import java.util.List;

import model.Vehiculo;

public interface VehiculosRepository {
	
	void nuevoVehiculo(Vehiculo vehiculo);
	
	void eliminarVehiculo(Vehiculo vehiculo);
	
	void actualizarVehiculo(Vehiculo vehiculo);
	
	List<Vehiculo> todosVehiculos();
	
	List<Vehiculo> vehiculosDisponibles(Date fechaInicio);
	
}
