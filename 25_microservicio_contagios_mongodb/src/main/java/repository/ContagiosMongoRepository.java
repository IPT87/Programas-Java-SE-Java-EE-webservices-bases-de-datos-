package repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import model.Registro;

public interface ContagiosMongoRepository extends MongoRepository<Registro, String> {
	
	List<Registro> findByPais(String pais);
	
	@Query("{$and:[{fecha:{$gte:?0}}, {fecha:{$lte:?1}}]}")
	List<Registro> registrosEntreFechas(String fechaInicio, String fechaFin);
	
}
