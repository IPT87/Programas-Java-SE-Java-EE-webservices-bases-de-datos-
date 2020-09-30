package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Contador
 */
@WebServlet("/Contador")
public class Contador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperamos el valor del contador, que esta en sesion
		//le sumamos uno y lo volvemos a guardar
		HttpSession session = request.getSession();
		Integer valor = (Integer) session.getAttribute("contador");
		valor++;
		session.setAttribute("contador", valor);
		//transferir peticion a la pagina de inicio
		request.getRequestDispatcher("inicio.html").forward(request, response);
	}

}
