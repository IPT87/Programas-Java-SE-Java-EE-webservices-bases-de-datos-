package repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dto.DtoFacturacion;
import model.Alquiler;
import model.Vehiculo;

public interface AlquileresJpaRepository extends JpaRepository<Alquiler, Integer> {

	@Query("SELECT a FROM Alquiler a WHERE a.fechaInicio >= ?1 AND a.fechaInicio <= ?2")
	List<Alquiler> findByFechaInicioBetween(Date desde, Date hasta);
	
	@Query("SELECT a FROM Alquiler a WHERE a.vehiculo.matricula = ?1")
	List<Alquiler> findByMatricula(String matricula);
	
	@Query("SELECT NEW dto.DtoFacturacion (a.vehiculo.matricula, SUM(a.facturacion)) FROM Alquiler a GROUP BY a.vehiculo.matricula")
	List<DtoFacturacion> facturacion();
	
	@Query("SELECT v FROM Vehiculo v JOIN v.alquileres a WHERE a.vehiculo.matricula = ?1 AND a.fechaInicio > ?2 ORDER BY a.fechaInicio")
	List<Vehiculo> reservasVehiculo(String matricula, Date fechaInicio);

}
