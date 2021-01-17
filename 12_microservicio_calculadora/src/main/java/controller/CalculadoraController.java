package controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {
	
	@GetMapping(value = "sumar/{num1}/{num2}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String sumar(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
		int resultado = num1 + num2;
		return num1 + " + " + num2 + " = " + resultado;
	}
	
	@GetMapping(value = "restar/{num1}/{num2}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String restar(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
		int resultado = num1 - num2;
		return num1 + " - " + num2 + " = " + resultado;
	}
	
	@GetMapping(value = "multiplicar/{num1}/{num2}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String multiplicar(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
		int resultado = num1 * num2;
		return num1 + " * " + num2 + " = " + resultado;
	}
	
}
