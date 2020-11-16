package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Alumno;
import service.FormacionService;

/**
 * Servlet implementation class AltaAlumnoAction
 */
@WebServlet("/AltaAlumnoAction")
public class AltaAlumnoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	FormacionService service;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		int edad = Integer.parseInt(request.getParameter("edad"));
		String email = request.getParameter("email");
		String nombre = request.getParameter("nombreAlumno");
		String password = request.getParameter("password");
		
		Alumno alumno = new Alumno(usuario, edad, email, nombre, password);
		
		if (service.buscarPorUsuario(usuario) == null || service.buscarPorUsuario(usuario).getUsuario().equals(usuario)) {
			service.altaAlumno(alumno);
			request.setAttribute("resultado", true);
		} else {
			request.setAttribute("resultado", false);
		}
	}

}
