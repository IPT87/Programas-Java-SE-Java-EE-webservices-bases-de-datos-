package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.AlquileresService;

@Controller
public class FacturacionController {
	@Autowired
	AlquileresService service;
	
	@GetMapping(value = "doFacturacion")
	public String facturacion(Model model) {
		model.addAttribute("facturacion", service.facturacion());
		return "facturacion";
	}

}
