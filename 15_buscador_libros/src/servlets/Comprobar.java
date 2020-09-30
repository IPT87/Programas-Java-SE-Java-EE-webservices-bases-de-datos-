package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Libro;
import service.LibrosFactory;
import service.LibrosService;

/**
 * Servlet implementation class Comprobar
 */
@WebServlet("/Comprobar")
public class Comprobar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eleccion = request.getParameter("busqueda");
		String texto = request.getParameter("valor");
		LibrosService service = LibrosFactory.getLibrosService();
		RequestDispatcher dispatcher;
		
		if (eleccion.equals("porTematica")) {
			List<Libro> libros = service.buscarPorTematica(texto);
			
			if(libros != null && libros.size() > 0) {
				request.setAttribute("libros",libros );
				dispatcher = request.getRequestDispatcher("librosTematica.jsp");
			} else {
				dispatcher = request.getRequestDispatcher("sinResultados.jsp");
			}
		} else {
			if (texto.length() > 0) {
				Libro libro = service.buscarLibro(Integer.parseInt(texto));
			
				if(libro!=null) {
					request.setAttribute("libro", libro);
					dispatcher = request.getRequestDispatcher("librosIsbn.jsp");
				}else {
					dispatcher = request.getRequestDispatcher("sinResultados.jsp");
				}
			} else {
				dispatcher = request.getRequestDispatcher("sinResultados.jsp");
			}
		}
		dispatcher.forward(request, response);
	}

}
