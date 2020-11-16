package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CandidatosService;

/**
 * Servlet implementation class EliminarPorEmail
 */
@WebServlet("/EliminarPorEmailAction")
public class EliminarPorEmailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CandidatosService service = new CandidatosService();
		
		String emailEliminar = request.getParameter("emailEliminar");
		
		if (service.buscarPorEmail(emailEliminar) != null) {
			service.eliminarCandidatoPorEmail(emailEliminar);
			request.setAttribute("resultado", true);
		} else {
			request.setAttribute("resultado", false);
		}
	}

}
