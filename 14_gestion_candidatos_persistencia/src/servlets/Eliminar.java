package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Candidato;
import service.CandidatosService;

/**
 * Servlet implementation class Eliminar
 */
@WebServlet("/Eliminar")
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CandidatosService service = new CandidatosService();
		
		int idCandidato = Integer.parseInt(request.getParameter("idCandidato"));
		
		service.eliminarCandidato(idCandidato);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("verCandidatos.jsp");
		dispatcher.forward(request, response);
	}

}
