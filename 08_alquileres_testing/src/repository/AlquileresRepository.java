package repository;

import java.util.Date;
import java.util.List;

import model.Alquiler;

public interface AlquileresRepository {
	Alquiler altaAlquiler(Alquiler alquiler);
	List<Alquiler> alquileresEntreFechas(Date fecha1, Date fecha2);
	List<Alquiler> alquileresVechiculo(String matricula);
	double facturacionVehiculo(String matricula);
}
