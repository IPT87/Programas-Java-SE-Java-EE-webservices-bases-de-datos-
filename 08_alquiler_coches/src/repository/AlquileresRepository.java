package repository;

import java.util.Date;
import java.util.List;

import dto.DtoFacturacion;
import model.Alquiler;

public interface AlquileresRepository {
	
	void nuevoAlquiler(Alquiler alquiler);
	
	List<Alquiler> todosVehiculos();
	
	List<DtoFacturacion> facturacion();
	
	List<Alquiler> reservas(Date desde, Date hasta);
	
	List<Alquiler> buscarAlquileresPorMatricula(String matricula);
	
}
