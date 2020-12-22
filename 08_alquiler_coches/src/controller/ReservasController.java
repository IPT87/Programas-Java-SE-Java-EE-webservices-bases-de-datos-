package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.DtoAlquiler;
import dto.Utilidades;
import model.Alquiler;
import service.AlquileresService;

@Controller
public class ReservasController {
	@Autowired
	AlquileresService service;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date fechaInicio = null;
	Date fechaFin = null;
	
	@GetMapping(value = "doReservas", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<DtoAlquiler> reservas(@RequestParam("fechaInicio") String fechaInicio, @RequestParam("fechaFin") String fechaFin) {
		
		try {
			this.fechaInicio = sdf.parse(fechaInicio);
			this.fechaFin = sdf.parse(fechaFin);
			List<Alquiler> alquileres = service.reservas(this.fechaInicio, this.fechaFin);
			
			return alquileres
					.stream()
					.map(alquiler -> Utilidades.convertirADtoAlquiler(alquiler))
					.collect(Collectors.toList());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return new ArrayList<DtoAlquiler>();
		
	}

}
