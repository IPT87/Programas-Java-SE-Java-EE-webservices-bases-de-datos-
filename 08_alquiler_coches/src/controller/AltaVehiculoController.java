package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Vehiculo;
import service.VehiculosService;

@Controller
public class AltaVehiculoController {
	@Autowired
	VehiculosService service;
	
	@PostMapping(value = "doAltaVehiculo")
	public String altaVehiculo(@RequestParam("matricula") String matricula, @RequestParam("marca") String marca,
								@RequestParam("modelo") String modelo, @RequestParam("color") String color,
								@RequestParam("potencia") int potencia, @RequestParam("precioDia") int precioDia) {
		
		Vehiculo vehiculo = new Vehiculo(matricula, color, marca, modelo, potencia, precioDia);
		service.nuevoVehiculo(vehiculo);
		return "toMenuPropietario";
		
	}

}
