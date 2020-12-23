package service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.DtoVehiculoDiasDisponible;
import model.Vehiculo;
import repository.VehiculosRepository;

@Service
public class VehiculosServiceImpl implements VehiculosService {
	@Autowired
	VehiculosRepository repository;

	@Override
	public void nuevoVehiculo(Vehiculo vehiculo) {
		repository.nuevoVehiculo(vehiculo);
	}

	@Override
	public void eliminarVehiculo(Vehiculo vehiculo) {
		repository.eliminarVehiculo(vehiculo);
	}

	@Override
	public void actualizarVehiculo(Vehiculo vehiculo) {
		repository.actualizarVehiculo(vehiculo);
	}

	@Override
	public List<Vehiculo> todosVehiculos() {
		return repository.todosVehiculos();
	}

	@Override
	public List<DtoVehiculoDiasDisponible> vehiculosDisponibles(Date fechaInicio) {
		List<DtoVehiculoDiasDisponible> vehiculosDiasDisponibles = new ArrayList<DtoVehiculoDiasDisponible>();
		List<Vehiculo> vehiculos = repository.vehiculosDisponibles(fechaInicio);
		int dias = 0;
		
		for (int i = 0; i < vehiculos.size(); i++) {
			if (vehiculos.get(i).getAlquileres().size() != 0) {
				dias = diasDisponibles(vehiculos.get(i), fechaInicio);
				vehiculosDiasDisponibles.add(new DtoVehiculoDiasDisponible(vehiculos.get(i).getMatricula(), vehiculos.get(i).getMarca(), vehiculos.get(i).getModelo(), vehiculos.get(i).getColor(), vehiculos.get(i).getPotencia(), vehiculos.get(i).getPrecioDia(), dias));
			} else {
				vehiculosDiasDisponibles.add(new DtoVehiculoDiasDisponible(vehiculos.get(i).getMatricula(), vehiculos.get(i).getMarca(), vehiculos.get(i).getModelo(), vehiculos.get(i).getColor(), vehiculos.get(i).getPotencia(), vehiculos.get(i).getPrecioDia(), 0));
			}
		}
		
		return vehiculosDiasDisponibles;
	}
	
	private int diasDisponibles(Vehiculo vehiculo, Date fechaElegida) {
		LocalDate fechaDeseadaAlquiler = fechaElegida.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate fechaInicialAlquiler = vehiculo.getAlquileres().get(0).getFechaInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int diferencia = (int) ChronoUnit.DAYS.between(fechaDeseadaAlquiler, fechaInicialAlquiler);
		int dias = diferencia;
		
		// En caso de que haya solo un alquiler en la lista
		if (vehiculo.getAlquileres().size() == 1) {
			return diferencia;
		} else {
			for (int i = 1; i < vehiculo.getAlquileres().size(); i++) {
				fechaInicialAlquiler = vehiculo.getAlquileres().get(i).getFechaInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				diferencia = (int) ChronoUnit.DAYS.between(fechaDeseadaAlquiler, fechaInicialAlquiler);
				
				if ((int) ChronoUnit.DAYS.between(fechaDeseadaAlquiler, fechaInicialAlquiler) < diferencia) {
					dias = (int) ChronoUnit.DAYS.between(fechaDeseadaAlquiler, fechaInicialAlquiler);
					diferencia = dias;
				}
			}
			return dias;
		}
	}

}
