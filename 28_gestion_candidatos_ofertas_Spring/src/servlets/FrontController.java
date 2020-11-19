package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		String url = "";

		switch (option) {
		case "toAlta":
			url = "nuevoCandidato.html";
			break;
		case "toEliminar":
			url = "emailEliminacion.html";
			break;
		case "toIncribir":
			url = "inscripcion.html";
			break;
		case "toMenu":
			url = "inicio.html";
			break;
		case "doRecuperarCandidatos":
			request.getRequestDispatcher("BuscarCandidatosAction").include(request, response);
			url = "verCandidatos.jsp";
			break;
		case "doAlta":
			request.getRequestDispatcher("RegistrarAction").include(request, response);
			break;
		case "doEliminarId":
			request.getRequestDispatcher("EliminarPorIdAction").include(request, response);
			request.getRequestDispatcher("BuscarCandidatosAction").include(request, response);
			url = "verCandidatos.jsp";
			break;
		case "doInscripcion":
			request.getRequestDispatcher("InscripcionAction").include(request, response);
			url = "inicio.html";
			break;
		case "doRecuperarInscripciones":
			request.getRequestDispatcher("RecuperarInscripcionesAction").include(request, response);
			url = "verInscripciones.jsp";
			break;
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

}
