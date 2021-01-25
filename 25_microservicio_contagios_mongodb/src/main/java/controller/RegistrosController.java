package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Registro;
import service.ContagiosService;

@RestController
public class RegistrosController {
	@Autowired
	ContagiosService service;
	
	@GetMapping(value = "registros/{pais}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Registro> registros(@PathVariable("pais") String pais) {
		return service.registrosPorPais(pais);
	}
	
	@GetMapping(value = "registros", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Registro> registrosPorFecha(@RequestParam("fecha1") String fecha1, @RequestParam("fecha2") String fecha2) {
		return service.registrosEntreFechas(fecha1, fecha2);
	}
	
	@PostMapping(value = "registro", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void agregarRegistro(@RequestBody Registro registro) {
		service.nuevoRegistro(registro);
	}

}
