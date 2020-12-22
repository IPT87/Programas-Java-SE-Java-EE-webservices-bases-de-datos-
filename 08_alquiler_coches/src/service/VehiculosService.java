package service;

import java.util.Date;
import java.util.List;

import dto.DtoVehiculoDiasDisponible;
import model.Vehiculo;

public interface VehiculosService {

	void nuevoVehiculo(Vehiculo vehiculo);
	
	void eliminarVehiculo(Vehiculo vehiculo);
	
	void actualizarVehiculo(Vehiculo vehiculo);
	
	List<Vehiculo> todosVehiculos();
	
	List<DtoVehiculoDiasDisponible> vehiculosDisponibles(Date fechaInicio);
	
}
