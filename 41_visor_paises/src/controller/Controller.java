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
		String inicio = "toInicio";
		String option = request.getParameter("option") != null ? request.getParameter("option") : inicio;
		String url = "infopaises.jsp";
		
		switch (option) {
		case "toInicio":
			request.getRequestDispatcher("MostrarPaisesAction").include(request, response);
			url = "infopaises.jsp";
			break;
		case "doPaisInfo":
			request.getRequestDispatcher("RecuperarDatosPaisAction").include(request, response);
			request.getRequestDispatcher("MostrarPaisesAction").include(request, response);
			url = "infopaises.jsp";
			break;
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
