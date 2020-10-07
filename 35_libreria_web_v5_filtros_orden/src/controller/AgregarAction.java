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
		Libro libro = new Libro (0, request.getParameter("titulo"), request.getParameter("autor"), Double.parseDouble(request.getParameter("precio")), 0, 0);
		List<Libro> libros;
		HttpSession session = request.getSession();
		
		libros = (ArrayList<Libro>) session.getAttribute("librosCarrito");
		libros.add(libro);
		//request.getRequestDispatcher("LibrosAction").include(request, response);
	}

}
