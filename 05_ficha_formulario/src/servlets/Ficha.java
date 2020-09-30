package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ficha
 */
@WebServlet("/Ficha")
public class Ficha extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String nombre = request.getParameter("nombre");
		String edad = request.getParameter("edad");

		String sexo = request.getParameter("sexo");
		String zona = request.getParameter("zona");
		String[] temas = request.getParameterValues("tema");
		out.println("<html><body><center>");

		out.println("<h1>Bienvenido " + sexo + ": " + nombre + ", " + edad + ", ");
		out.println("Pertenece a la zona: <b>" + zona + "</b></h1>");
		out.println("<br/>temas elegidos:<br/>");
		if (temas != null) {
			for (String s : temas) {
				out.println("<b>" + s + "</b><br/>");
			}
		}
		out.println("</center></body></html>");

	}

}
