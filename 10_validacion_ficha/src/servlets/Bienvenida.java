package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;

/**
 * Servlet implementation class Bienvenida
 */
@WebServlet("/Bienvenida")
public class Bienvenida extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		//recuperar datos de la ficha del cliente
		Cliente cliente = (Cliente) request.getAttribute("ficha");
		out.println("<html><body><center>");
		out.println("<h1>Bienvenido a mi servlet!</h1>");
		out.println("<h2>Usuario: " + cliente.getUser() + "</h2>");
		out.println("<h2>edad: " + cliente.getEdad() + "</h2>");
		out.println("<h2>email: " + cliente.getEmail() + "</h2>");
		out.println("<a href='inicio.html'>Volver</a>");
		out.println("</center></body></html>");
		out.close();
	}

}
