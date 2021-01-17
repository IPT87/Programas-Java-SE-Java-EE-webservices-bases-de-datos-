package repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Vehiculo;

public interface VehiculosJpaRepository extends JpaRepository<Vehiculo, String> {
	//
	@Query("Select distinct v From Vehiculo v left join fetch v.alquileres a Where v Not In (Select c From Vehiculo c join c.alquileres q Where q.fechaInicio <=?1 and  q.fechaFin>=?1)") //
	List<Vehiculo> findVehiculosDisponibles(Date fecha);
	
}
