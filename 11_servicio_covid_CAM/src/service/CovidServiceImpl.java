package service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Conjunto;
import model.Item;

@Service
public class CovidServiceImpl implements CovidService {
	@Autowired
	RestTemplate template;
	private String url = "https://datos.comunidad.madrid/catalogo/dataset/7da43feb-8d4d-47e0-abd5-3d022d29d09e/resource/877fa8f5-cd6c-4e44-9df5-0fb60944a841/download/covid19_tia_muni_y_distritos_s.json";
	int suma = 0;
	
	@Override
	public List<Item> casosMunicipio(String municipio) {
		Conjunto conjunto = template.getForObject(url, Conjunto.class);
		// Stream con todos los Item
		return Arrays.stream(conjunto.getData())
						.filter(it -> it.getMunicipio_distrito().equals(municipio))
						.collect(Collectors.toList());
	}

	@Override
	public List<Item> casosEntreFechas(Date fechaInicio, Date fechaFin) {
		Conjunto conjunto = template.getForObject(url, Conjunto.class);
		return Arrays.stream(conjunto.getData())
				.filter(it -> it.getFecha_informe().compareTo(fechaInicio) >= 0 && it.getFecha_informe().compareTo(fechaFin) <= 0)
				.collect(Collectors.toList());
	}

	@Override
	public int casosTotalesAcumulados() {
		suma = 0;
		Conjunto conjunto = template.getForObject(url, Conjunto.class);
		Map<String, List<Item>> agrupados = Arrays.stream(conjunto.getData())
				.collect(Collectors.groupingBy(it -> it.getMunicipio_distrito()));
		agrupados.forEach((k, v) -> suma += v.get(0).getCasos_confirmados_totales());
		return suma;
	}

}
