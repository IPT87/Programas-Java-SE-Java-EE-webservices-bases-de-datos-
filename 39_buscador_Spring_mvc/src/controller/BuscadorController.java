package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Item;
import service.BuscadorService;

@Controller
public class BuscadorController {
	@Autowired
	BuscadorService service;

	@PostMapping("doBuscar")
	public String buscar(@RequestParam("tema") String palabra, HttpServletRequest request) {
		List<Item> items = service.buscarItems(palabra);
		request.setAttribute("items", items);
		return "resultados";
		// return "forward:/doLogin"; // indica a DispatcerServlet que transfiera la peticion a otro controler
	}
}
