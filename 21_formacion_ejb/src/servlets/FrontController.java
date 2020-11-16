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
		case "toInicio":
			url = "inicio.html";
			break;
		case "toNuevoAlumno":
			url = "altaAlumno.html";
			break;
		case "toNuevoCurso":
			url = "altaCurso.html";
			break;
		case "doAltaAlumno":
			request.getRequestDispatcher("AltaAlumnoAction").include(request, response);
			boolean resultado = (boolean) request.getAttribute("resultado");
			url = resultado ? "inicio.html" : "errorAltaAlumno.html";
			break;
		case "doAltaCurso":
			request.getRequestDispatcher("AltaCursoAction").include(request, response);
			break;
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

}
