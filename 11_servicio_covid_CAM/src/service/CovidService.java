package service;

import java.util.Date;
import java.util.List;

import model.Item;

public interface CovidService {
	List<Item> casosMunicipio(String municipio);
	List<Item> casosEntreFechas(Date fechaInicio, Date fechaFin);
	int casosTotalesAcumulados();
}
