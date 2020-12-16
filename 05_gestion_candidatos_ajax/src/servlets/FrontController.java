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
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="";
		String option=request.getParameter("option");
		switch(option) {
			case "doAltaCandidato":
				request.getRequestDispatcher("AltaCandidatoAction").include(request, response);
				url="menu.html";
				break;
			case "doAltaInscripcion":
				request.getRequestDispatcher("AltaInscripcionAction").include(request, response);
				url="menu.html";
				break;
			case "doBuscarCandidatos":
				request.getRequestDispatcher("BuscarCandidatosAction").forward(request, response);
				return;
			case "doBuscarInscripciones":
				request.getRequestDispatcher("BuscarInscripcionesAction").include(request, response);
				url="inscripciones.jsp";
				break;
			case "toCargarCandidatos":
				url="ofertas.jsp";
				break;
			case "doEliminarCandidato":
				request.getRequestDispatcher("EliminarCandidatoAction").include(request, response);
				url="candidatos.jsp";
				break;
			case "doBuscarEmpresas":
				request.getRequestDispatcher("BuscarEmpresasAction").include(request, response);
				url="empresas.jsp";
				break;
			case "doInscripcionesEmpresa":
				request.getRequestDispatcher("InscripcionesEmpresaAction").forward(request, response);
				return;
			case "toBuscarCandidatos":
				url="candidatos.jsp";
				break;
			case "toMenu":
				url="menu.html";
				break;
			case "toAlta":
				url="alta.html";
						
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
