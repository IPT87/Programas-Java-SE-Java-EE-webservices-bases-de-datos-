package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TablaNumeroServlet
 */
@WebServlet("/TablaNumeroServlet")
public class TablaNumeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		int numero = Integer.parseInt(request.getParameter("numero"));
		out.println("<html><body><center>");
		out.println("Tabla de " + numero);
		out.println("<table border='1'>");
		for (int fila = 1; fila <= 10; fila++) {
			out.println("<tr>");	
			out.print("<td> " + numero + " x " + fila + "</td>");
			out.print("<td> " + (numero * fila) + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<a href='numero.html'>Volver</a>");
		out.println("</center></body></html>");
		out.close();
	}

}
