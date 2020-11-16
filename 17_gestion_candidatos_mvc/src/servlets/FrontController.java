package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@MultipartConfig
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String option = request.getParameter("option");
		String url = "";

		switch (option) {
		case "toAlta":
			url = "nuevoCandidato.html";
			break;
		case "toEliminar":
			url = "emailEliminacion.html";
			break;
		case "doRecuperar":
			request.getRequestDispatcher("RecuperarAction").include(request, response);
			url = "verCandidatos.jsp";
			break;
		case "doAlta":
			request.getRequestDispatcher("RegistrarAction").include(request, response);
			break;
		case "doEliminarId":
			request.getRequestDispatcher("EliminarPorIdAction").include(request, response);
			request.getRequestDispatcher("RecuperarAction").include(request, response);
			url = "verCandidatos.jsp";
			break;
		case "doEliminarEmail":
			request.getRequestDispatcher("EliminarPorEmailAction").include(request, response);
			boolean resultado = (boolean) request.getAttribute("resultado");
			url = resultado ? "inicio.html" : "errorEliminar.html";
			break;
		case "toMenu":
			url = "inicio.html";
			break;
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

}
