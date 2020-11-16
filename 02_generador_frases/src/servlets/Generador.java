package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Generador
 */
@WebServlet("/Generador")
public class Generador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//generar respuesta
		//el tipo de dato que enviaremos como respuesta
		response.setContentType("text/html");
		//construimos la pagina usando entrada-salida Java
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		for(int i = 0; i < 10; i++) {
			int n = (int)(Math.random() * 30 + 5); //aleatorio entre 5 y 35
			out.println("<p style='font-size:" + n + "px'>");
			out.println("Texto de tamaño aleatorio</p>");
		}
		out.println("</body></html>");
	}

}
