package controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Libro;
import service.LibrosService;
import service.TemasService;


/**
 * Servlet implementation class LibrosAction
 */
@WebServlet("/LibrosAction")
public class LibrosAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	LibrosService glibros;
	@Inject
	TemasService gtemas;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idTema=Integer.parseInt(request.getParameter("tema"));
	
		List<Libro> libros;
		
		if(idTema == 0) {
			libros = glibros.recuperarLibros();
		}
		else {
			libros = glibros.recuperarLibros(idTema);
		}
		request.setAttribute("libros", libros);
		request.setAttribute("tema", idTema > 0 ? gtemas.recuperarTemaPorId(idTema).getTema() : "Todos");
	}

}
