package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Iniciar
 */
@WebServlet("/Iniciar")
public class Iniciar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "login.html";
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for (Cookie ck : cookies) {
				if(ck.getName().equals("credenciales")) {
					String[] datos = ck.getValue().split("[-]");
					url = "Comprobar?usuario=" + datos[0] + "&passUsuario=" + datos[1];
				}
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
