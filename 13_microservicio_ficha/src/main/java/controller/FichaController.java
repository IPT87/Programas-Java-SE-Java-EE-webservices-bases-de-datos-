package controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Ficha;

@RestController
public class FichaController {
	
	@GetMapping(value = "datos/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Ficha datosPersona(@PathVariable("dni") String dni) {
		return new Ficha("Prueba ficha", dni, 20);
	}
	
}
