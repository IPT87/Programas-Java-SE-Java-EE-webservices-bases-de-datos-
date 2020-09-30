package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TablaMultiplicarServlet
 */
@WebServlet("/TablaMultiplicarServlet")
public class TablaMultiplicarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body><center><table border='1'>");
		for (int fila = 1; fila <= 10; fila++) {
			out.println("<tr>");
			for (int col = 1; col <= 10; col++) {	
				out.print("<td> " + (fila * col) + "</td>");
			}
			out.println("</tr>");
		}
		out.println("</table></center></body></html>");
		out.close();
	}

}
