package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Item;
import service.CovidService;

@RestController
public class CovidController {
	@Autowired
	CovidService service;
	
	@GetMapping(value = "casos/{municipio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Item>> casosMunicipio(@PathVariable("municipio") String municipio) {
		List<Item> body = service.casosMunicipio(municipio);
		HttpHeaders headers = new HttpHeaders();
		if (body == null || body.size() == 0) {
			headers.add("error", "El municipio indicado no existe");
		}
		return new ResponseEntity<List<Item>>(body, headers, HttpStatus.OK);
	}
	
	/*
	@GetMapping(value = "casos/{f1}/{f2}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Item> casosPorFecha(@PathVariable("f1") String fecha1, @PathVariable("f2") String fecha2) {
		/* LocalDate f1 = LocalDate.parse(fecha1);
		LocalDate f2 = LocalDate.parse(fecha2);
		
		return service.casosEntreFechas(Date.from(f1.atStartOfDay(ZoneId.systemDefault()).toInstant()), 
										Date.from(f2.atStartOfDay(ZoneId.systemDefault()).toInstant())); */
		
	/*	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return service.casosEntreFechas(formato.parse(fecha1), formato.parse(fecha2));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	} */
	
	@GetMapping(value = "casos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Item> casosPorFecha(@RequestParam("f1") String fecha1, @RequestParam("f2") String fecha2) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return service.casosEntreFechas(formato.parse(fecha1), formato.parse(fecha2));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping(value = "total", produces = MediaType.TEXT_PLAIN_VALUE)
	public String casosTotales() {
		return String.valueOf(service.casosTotalesAcumulados());
	}
}
