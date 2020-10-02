package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controler
 */
@WebServlet("/Controler")
public class Controler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		String url = "login.html";

		switch (option) {
			case "doAutenticar":
				request.getRequestDispatcher("AutenticarAction").include(request, response);
				url = (Boolean) request.getAttribute("resultadoAutenticar") ? "temas.jsp" : "error.html";
				break;
			case "doRegistrar":
				request.getRequestDispatcher("RegistrarAction").include(request, response);
				url = (Boolean) request.getAttribute("resultadoRegistrar") ? "login.html" : "error.html";
				break;
			case "toRegistrar":
				url = "registrar.html";
				break;
			case "toSalir":
				url = "login.html";
				break;
			case "toTemas":
				url = "temas.jsp";
				break;
			case "toError":
				url = "error.html";
				break;
			case "toListaTemas":
				url = "listaTemas.jsp";
				break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
