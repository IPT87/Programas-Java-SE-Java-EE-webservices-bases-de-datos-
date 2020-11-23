package controller;

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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="";
		String option=request.getParameter("option");
		switch(option) {
			case "doAltaAlumno":
				request.getRequestDispatcher("AltaAlumnoAction").include(request, response);
				url=(boolean)request.getAttribute("resultado")?"menu.html":"usuariorepetido.jsp";
				break;
			case "doAltaCurso":
				request.getRequestDispatcher("AltaCursoAction").include(request, response);
				url="menu.html";
				break;
			case "doAlumnos":
				request.getRequestDispatcher("AlumnosAction").include(request, response);
				url="seleccionalumnos.jsp";
				break;
			case "doCursos":
				request.getRequestDispatcher("CursosAction").include(request, response);
				url="seleccioncursos.jsp";
				break;
			case "doAlumnosCurso":
				request.getRequestDispatcher("AlumnosCursoAction").include(request, response);
				url="alumnoscurso.jsp";
				break;
			case "doCursosAlumno":
				request.getRequestDispatcher("CursosAlumnoAction").include(request, response);
				url="cursosalumno.jsp";
				break;
			case "doSeleccionAlumnoMatricular":
				request.getRequestDispatcher("AlumnosAction").include(request, response);
				url="alumnosmatricular.jsp";
				break;
			case "doSeleccionCursoMatricular":
				request.getRequestDispatcher("CursosMatricularAction").include(request, response);
				url="cursosmatricular.jsp";
				break;
			case "doMatricular":
				request.getRequestDispatcher("MatricularAction").include(request, response);
				url="menu.html";
				break;
			case "toAltaAlumno":
				url="altaAlumno.html";
				break;
			case "toAltaCurso":
				url="altaCurso.html";
				break;
			case "toMenu":
				url="menu.html";
				break;
						
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
