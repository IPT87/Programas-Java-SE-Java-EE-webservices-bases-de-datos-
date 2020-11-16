package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Autenticar
 */
@WebServlet("/Autenticar")
public class Autenticar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USUARIO = "admin";
	private static final String PASS = "admin";

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		RequestDispatcher dispatcher;
		
		if(usuario.equals(USUARIO) && password.equals(PASS)) {
			//guardamos el usuario en un atributo de sesion
			//para que sea recordado durante toda su navegacion
			HttpSession sesion = request.getSession();
			sesion.setAttribute("user", usuario);
			//transferimos peticion al buscador
			dispatcher = request.getRequestDispatcher("buscador.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("noautenticado.jsp");
		}
		
		dispatcher.forward(request, response);
	}

}
