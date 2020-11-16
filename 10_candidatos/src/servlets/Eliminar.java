package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Candidato;

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
		HttpSession sesion = request.getSession();
		
		List<Candidato> candidatos = (List<Candidato>)sesion.getAttribute("candidatos");
		int posicion = Integer.parseInt(request.getParameter("posicion"));
		
		if(candidatos.size() > 0) {
			synchronized (candidatos) {
				candidatos.remove(candidatos.get(posicion));
			}
		} else {
			request.getRequestDispatcher("inicio.html").forward(request, response);
		}
		
		sesion.setAttribute("candidatos", candidatos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("verCandidatos.jsp");
		dispatcher.forward(request, response);
	}

}
