package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.DtoVehiculoDiasDisponible;
import service.VehiculosService;

@Controller
public class CochesDisponiblesController {
	@Autowired
	VehiculosService service;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date fechaInicio = null;
	
	@GetMapping(value = "doVehiculosDisponibles", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<DtoVehiculoDiasDisponible> vehiculosDisponibles(@RequestParam("fechaInicio") String fechaInicio) {
		
		try {
			this.fechaInicio = sdf.parse(fechaInicio);
			
			return service.vehiculosDisponibles(this.fechaInicio);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return new ArrayList<DtoVehiculoDiasDisponible>();
		
		
		
	}

}
