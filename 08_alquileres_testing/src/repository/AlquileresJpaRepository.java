package repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Alquiler;

public interface AlquileresJpaRepository extends JpaRepository<Alquiler, Integer> {
	@Query("Select distinct a From Alquiler a Where a.fechaInicio between ?1 and ?2")
	List<Alquiler> findAlquilerFechaInicioBetween(Date fecha1, Date fecha2);
	List<Alquiler> findAlquilerByVehiculoMatricula(String matricula);
	@Query("Select sum(a.facturacion) from Alquiler a where a.vehiculo.matricula=?1")
	double facturacionVehiculo(String matricula);
}
