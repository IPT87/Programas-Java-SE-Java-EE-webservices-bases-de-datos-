package repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Vehiculo;

public interface VehiculosJpaRepository extends JpaRepository<Vehiculo, String> {

	@Query("SELECT DISTINCT v FROM Vehiculo v LEFT JOIN FETCH v.alquileres a WHERE v NOT IN (SELECT DISTINCT c FROM Vehiculo c JOIN c.alquileres b WHERE b.fechaInicio < ?1 AND b.fechaFin > ?1)")
	List<Vehiculo> vehiculosDisponibles(Date fechaInicio);
	
}
