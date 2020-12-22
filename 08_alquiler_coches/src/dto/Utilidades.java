package dto;

import model.Alquiler;
import model.Vehiculo;

public class Utilidades {

	public static DtoVehiculo convertirADtoVehiculo(Vehiculo vehiculo) {
		return new DtoVehiculo(vehiculo.getMatricula(),
								vehiculo.getColor(),
								vehiculo.getMarca(),
								vehiculo.getModelo(),
								vehiculo.getPotencia(),
								vehiculo.getPrecioDia());
	}
	
	public static DtoAlquiler convertirADtoAlquiler(Alquiler alquiler) {
		return new DtoAlquiler(alquiler.getIdAlquiler(),
								alquiler.getEmailContacto(),
								alquiler.getFacturacion(),
								alquiler.getFechaFin(),
								alquiler.getFechaInicio(),
								alquiler.getVehiculo() == null ? new DtoVehiculo() : Utilidades.convertirADtoVehiculo(alquiler.getVehiculo()));
	}
	
}
