package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Libro;
import service.LibreriaFactory;
import service.LibrosService;

/**
 * Servlet implementation class AgregarAction
 */
@WebServlet("/AgregarAction")
public class AgregarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		List<Libro> libros = (ArrayList<Libro>) session.getAttribute("librosCarrito");
		
		int isbn = Integer.parseInt(request.getParameter("isbn"));
		LibrosService glibros = LibreriaFactory.getLibrosService();
		
		libros.add(glibros.recuperarLibroPorIsbn(isbn));
		request.getRequestDispatcher("LibrosAction").include(request, response);
	}

}
