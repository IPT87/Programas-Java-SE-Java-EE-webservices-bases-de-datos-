/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.LibrosDao;
import model.Libro;

@RequestScoped
@Named("librosService")
 public class LibrosServiceImpl implements LibrosService { 
	@Inject
	@Named("librosDaoWeb")
	LibrosDao librosDao;
    @Override
	public List<Libro> recuperarLibros(){
    	return librosDao.recuperarTodos();
    }
    @Override
	public List<Libro> recuperarLibros(int idTema){
    	return librosDao.recuperarPorTema(idTema);
    }
    
    public Libro recuperarLibroPorIsbn(int isbn) {
		return librosDao.recuperarPorIsbn(isbn);
    }
}
