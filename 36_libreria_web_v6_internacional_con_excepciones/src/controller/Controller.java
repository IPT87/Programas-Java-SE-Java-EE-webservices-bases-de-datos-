package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		String url = "login.jsp";
		switch(option) {
			case "doRegistrar":
				request.getRequestDispatcher("RegistrarAction").include(request, response);
				url = "login.jsp";
				break;
			case "doLogin":
				request.getRequestDispatcher("LoginAction").include(request, response);
				url = (Boolean)request.getAttribute("resultado") ? "temas.jsp" : "error.html";
				break;
			case "doTemas":
				request.getRequestDispatcher("TemasAction").include(request, response);
				url = "temas.jsp";
				break;
			case "doLibros":
				request.getRequestDispatcher("LibrosAction").include(request, response);
				url = "libros.jsp";
				break;
			case "toRegistro":
				url = "registro.html";
				break;
			case "toSalir":
				url = "login.jsp";
				break;
			case "doAgregar":
				request.getRequestDispatcher("AgregarAction").include(request, response);
				url = "libros.jsp";
				break;
			case "doEliminar":
				request.getRequestDispatcher("EliminarAction").include(request, response);
				url = "libros.jsp";
				break;
			case "doCompra":
				request.getRequestDispatcher("ComprarAction").include(request, response);
				url = (Boolean)request.getAttribute("resultadoVenta") ? "compraTerminada.html" : "errorVenta.jsp";
				break;
			case "doIdioma":
				request.getRequestDispatcher("CambiarIdiomaAction").include(request, response);
				url = "login.jsp";
				break;
			
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
