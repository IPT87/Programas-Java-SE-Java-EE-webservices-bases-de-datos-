package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import model.Pais;
import service.PaisesService;

@Api(value = "Servicio de informacion de paises.")
@RestController
public class PaisesController {
	@Autowired
	PaisesService service;
	
	@ApiOperation(value = "Devuelve la lista de paises de un continente.")
	@GetMapping(value = "paises/{continente}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> paisesContinente(@ApiParam(value = "Nombre del continente.") @PathVariable("continente") String continente) {
		return service.paisesPorContinente(continente);
	}
	
	@ApiOperation(value = "Devuelve la lista de continentes.")
	@GetMapping(value = "continentes", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> sontinentes() {
		return service.continentes();
	}
	
	@ApiOperation(value =  "Obtiene los datos de un pais a partir de su nombre.")
	@GetMapping(value = "pais/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Pais buscarPaises(@ApiParam(value = "Nombre del pais.") @PathVariable("nombre") String nombre) {
		return service.buscarPais(nombre);
	}

}
