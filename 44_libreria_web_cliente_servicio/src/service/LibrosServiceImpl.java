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
    @Override
    public Libro recuperarLibroPorIsbn(int isbn) {
		return recuperarLibroPorIsbn(isbn);
    }
    
}
