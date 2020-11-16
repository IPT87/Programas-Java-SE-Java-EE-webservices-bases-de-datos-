package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Error
 */
@WebServlet("/Error")
public class Error extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//los parametros que le llegaron al servlet de origen
		//estan disponibles tambien en el destino
		String tema = request.getParameter("tema");
		
		out.println("<html><body>");
		out.println("<h2>Lo siento, no existen entradas para el tema " + "\"" + tema + "\"" + "...</h2>");
		out.println("<a href='buscador.html'>Volver</a>");
		out.println("</body></html>");
	}

}
