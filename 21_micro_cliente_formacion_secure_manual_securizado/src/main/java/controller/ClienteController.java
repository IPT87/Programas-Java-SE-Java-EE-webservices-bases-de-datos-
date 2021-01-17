package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.ItemAlumno;
import model.ItemCurso;
import service.ClienteService;

@CrossOrigin("*")
@RestController
public class ClienteController {
	@Autowired
	ClienteService service;
	/*
	 Usuarios y roles para este servicio:
	 test1/test1 perteneciente al rol USERS
	 test2/test2 perteneciente a los roles USERS y OPERATORS
	 */
	
	// Puede acceder cualquier usuario autenticado
	@GetMapping(value="cursos",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ItemCurso>> cursos(){
		List<ItemCurso> body= service.cursos();
		HttpHeaders headers=new HttpHeaders();
		headers.add("totalCursos", body.size()+"");
		return new ResponseEntity<List<ItemCurso>>(body,headers,HttpStatus.OK);
	}
	// Solo usuarios miembros del rol OPERATORS
	@GetMapping(value="alumnos/{curso}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ItemAlumno>> alumnosCurso(@PathVariable("curso") int codigo){
		
		List<ItemAlumno> body= service.alumnosCurso(codigo);
		HttpHeaders headers=new HttpHeaders();
		headers.add("totalAlumnos", body.size()+"");
		return new ResponseEntity<List<ItemAlumno>>(body,headers,HttpStatus.OK);
	}
}
