package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		Map<Integer, String> usuarios = new HashMap<>();
		usuarios.put(1234, "Juan");
		usuarios.put(7777, "Paco");
		usuarios.put(4321, "Carla");
		usuarios.put(0000, "Maria");
		usuarios.put(2222, "Roberto");
		
		int pass = Integer.parseInt(request.getParameter("passUsuario"));
		String nombreUsuario = request.getParameter("usuario");
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession();
		
		if (usuarios.containsKey(pass)) {
			if (usuarios.get(pass).equals(nombreUsuario)) {
				session.setAttribute("usuario", nombreUsuario);
				dispatcher = request.getRequestDispatcher("eleccion.jsp");
			} else {
				dispatcher = request.getRequestDispatcher("accesoDenegado.jsp");
			}
		} else {
			dispatcher = request.getRequestDispatcher("accesoDenegado.jsp");
		}
		
		dispatcher.forward(request, response);
	}

}
