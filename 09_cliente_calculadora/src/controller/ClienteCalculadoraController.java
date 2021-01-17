package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.CalculadoraService;

@Controller
public class ClienteCalculadoraController {
	@Autowired
	CalculadoraService service;
	
	@PostMapping(value = "sumar")
	public String sumar(@RequestParam("n1") int a, @RequestParam("n2") int b, Model model) {
		String resultado = service.sumar(a, b);
		model.addAttribute("resultado", resultado);
		return "calculadora";
	}
	
	@PostMapping(value = "restar")
	public String restar(@RequestParam("n1") int a, @RequestParam("n2") int b, Model model) {
		String resultado = service.restar(a, b);
		model.addAttribute("resultado", resultado);
		return "calculadora";
	}
	
	@PostMapping(value = "multiplicar")
	public String multiplicar(@RequestParam("n1") int a, @RequestParam("n2") int b, Model model) {
		String resultado = service.multiplicar(a, b);
		model.addAttribute("resultado", resultado);
		return "calculadora";
	}
	
}
