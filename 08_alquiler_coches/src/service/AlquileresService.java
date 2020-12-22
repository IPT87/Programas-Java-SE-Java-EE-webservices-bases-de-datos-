package service;

import java.util.Date;
import java.util.List;

import dto.DtoFacturacion;
import model.Alquiler;

public interface AlquileresService {

	void nuevoAlquiler(Alquiler alquiler);
	
	List<DtoFacturacion> facturacion();
	
	List<Alquiler> reservas(Date desde, Date hasta);
	
}
