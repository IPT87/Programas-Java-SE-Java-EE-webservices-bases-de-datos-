package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CandidatosService;

/**
 * Servlet implementation class Eliminar
 */
@WebServlet("/EliminarPorIdAction")
public class EliminarPorIdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	CandidatosService service;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idCandidato = Integer.parseInt(request.getParameter("idCandidato"));
		
		service.eliminarCandidato(idCandidato);
		
	}

}
