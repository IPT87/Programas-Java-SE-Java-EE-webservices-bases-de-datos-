package service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import model.Caso;

public interface BaseService {

	Stream<Caso> streamCaso();

	List<Caso> casosEntreFechas(Date fechaini, Date fechafin);

	List<Caso> casosEntreFechasComunidad(Date fechaini, Date fechafin, String comunidad);

	List<String> comunidades();

	int casosEnDia(Date fecha);

	Date picoContagios();

	int mediaPositivos();

	int totalPositivosComunidad(String nombre);

	Map<String, List<Caso>> casosPorComunidad();

	List<Caso> casosDeComunidad(String comunidad);

}