package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Item;
import service.BuscadorService;

@Controller
public class BuscadorController {
	@Autowired
	BuscadorService service;
	
	@GetMapping(value = "doBuscar", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Item> buscar(@RequestParam("tema") String palabra) {
		List<Item> items = service.buscarItems(palabra);
		return items;
		//return "forward:/doLogin"; //indica a DispatcherServlet que transfiera la petici�n a otro controller
	}
}
