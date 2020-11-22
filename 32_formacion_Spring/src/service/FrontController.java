package service;

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
		String url = "";
		String option = request.getParameter("option");
		
		switch (option) {
		case "toBuscarAlumnoPorUsuario":
			url="buscarAlumnoPorUsuario.html";
			break;
		case "toBuscarAlumnoPorCurso":
			url="buscarAlumnoPorCurso.html";
			break;
		case "toBuscarCursoPorAlumno":
			url="buscarCursoPorAlumno.html";
			break;
		case "toInicio":
			url="inicio.html";
			break;
		case "toAltaAlumno":
			url="altaAlumno.html";
			break;
		case "toAltaCurso":
			url="altaCurso.html";
			break;
		case "doAltaAlumno":
			request.getRequestDispatcher("AltaAlumnoAction").include(request, response);
			url="inicio.html";
			break;
		case "doAltaCurso":
			request.getRequestDispatcher("AltaCursoAction").include(request, response);
			url="inicio.html";
			break;
		case "doBuscarAlumnoPorCurso":
			request.getRequestDispatcher("BuscarAlumnoPorCursoAction").include(request, response);
			url="verAlumnoCurso.jsp";
			break;
		case "doBuscarAlumnoPorUsuario":
			request.getRequestDispatcher("BuscarAlumnoPorUsuarioAction").include(request, response);
			url="verAlumnoUsuario.jsp";
			break;
		case "doBuscarCursoPorAlumno":
			request.getRequestDispatcher("BuscarCursoPorAlumnoAction").include(request, response);
			url="verCursoAlumno.jsp";
			break;
		case "doRecuperarAlumnos":
			request.getRequestDispatcher("RecuperarAlumnosAction").include(request, response);
			url="verAlumnos.jsp";
			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
