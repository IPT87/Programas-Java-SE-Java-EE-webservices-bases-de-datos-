package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String passCorrecta = "java";
		String passRecibida = request.getParameter("pass");
		
		if(passRecibida.equals(passCorrecta)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Bienvenida");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Error");
			dispatcher.forward(request, response);
		}
	}

}
