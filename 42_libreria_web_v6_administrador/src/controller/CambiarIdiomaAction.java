package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CambiarIdiomaAction
 */
@WebServlet("/CambiarIdiomaAction")
public class CambiarIdiomaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idioma = request.getParameter("idioma");
		HttpSession sesion = request.getSession();
		sesion.setAttribute("javax.servlet.jsp.jstl.fmt.locale.session", idioma);
	}

}
