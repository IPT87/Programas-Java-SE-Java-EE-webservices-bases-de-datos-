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
		try {
			int numero = Integer.parseInt(request.getParameter("numero"));
			//transferencia de peticion a servlet TablaNumero
			RequestDispatcher dispatcher = request.getRequestDispatcher("TablaNumeroServlet");
			dispatcher.forward(request, response);
		} catch(NumberFormatException e) {
			//transferencia de peticion a servlet de error
			RequestDispatcher dispatcher = request.getRequestDispatcher("Error");
			dispatcher.forward(request, response);
		}
	}

}
