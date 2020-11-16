package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Curso;
import service.FormacionFactory;
import service.FormacionService;

/**
 * Servlet implementation class AltaCursoAction
 */
@WebServlet("/AltaCursoAction")
public class AltaCursoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormacionService service = FormacionFactory.getFormacionService();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String fechaInicio = request.getParameter("fechaInicio");
		int duracion = Integer.parseInt(request.getParameter("duracion"));
		String nombre = request.getParameter("nombreCurso");
		
		Curso curso = null;
		try {
			curso = new Curso(0, format.parse(fechaInicio), duracion, nombre);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		service.altaCurso(curso);
	}

}
