package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import model.Pais;

@Service
public class PaisesServiceImpl implements PaisesService {
	@Autowired
	RestTemplate template;
	String url = "https://restcountries.eu/rest/v2/all";

	@Override
	public List<Pais> paisesPorContinente(String continente) {
		String respuesta = template.getForObject(url, String.class);
		ObjectMapper maper = new ObjectMapper();
		List<Pais> paises = new ArrayList<>();
		ArrayNode array;
		try {
			//obtenemos ArrayJson con los datos de la respuesta
			array = (ArrayNode)maper.readTree(respuesta);			
			for(Object ob:array) {
				//obtenemos el objeto Json y extraemos
				//las propiedades que nos interesan				
				ObjectNode json = (ObjectNode)ob;
				if(json.get("region").asText().equals(continente)) {
					paises.add(new Pais(json.get("name").asText(),
							json.get("capital").asText(),
							json.get("population").asInt(),
							((ObjectNode)(((ArrayNode)json.get("currencies")).get(0))).get("name").asText(),
							json.get("region").asText()
							));
				}
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}			
			
		return paises;

	}

	@Override
	public List<String> continentes() {
		String respuesta = template.getForObject(url, String.class);
		ObjectMapper maper = new ObjectMapper();
		List<String> continentes = new ArrayList<>();
		ArrayNode array;
		
		try {
			//obtenemos ArrayJoson con los datos de la respuesta
			array = (ArrayNode)maper.readTree(respuesta);			
			for(Object ob:array) {
				//obtenemos el objeto Json y extraemos
				//las propiedades que nos interesan				
				ObjectNode json = (ObjectNode)ob;
				String continente = json.get("region").asText();
				
				if(!continentes.contains(continente)) {
					continentes.add(continente);
				}
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}	
		
		return continentes;
	}

	@Override
	public Pais buscarPais(String nombre) {
		String respuesta = template.getForObject(url, String.class);
		ObjectMapper maper = new ObjectMapper();
		Pais pais = null;
		ArrayNode array;
		
		try {
			//obtenemos ArrayJoson con los datos de la respuesta
			array = (ArrayNode)maper.readTree(respuesta);			
			for(Object ob:array) {
				//obtenemos el objeto Json y extraemos
				//las propiedades que nos interesan				
				ObjectNode json = (ObjectNode)ob;
				
				if(json.get("name").asText().equals(nombre)) {
					pais = new Pais(json.get("name").asText(),
							json.get("capital").asText(),
							json.get("population").asInt(),
							((ObjectNode)(((ArrayNode)json.get("currencies")).get(0))).get("name").asText(),
							json.get("region").asText()
							);
				}
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}	
		
		return pais;
	}

}
