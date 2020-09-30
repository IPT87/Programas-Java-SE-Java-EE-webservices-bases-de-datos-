package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Producto;

/**
 * Servlet implementation class Guardar
 */
@WebServlet("/Guardar")
public class Guardar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("producto");
		double precio = Double.parseDouble(request.getParameter("precio"));
		String categoria = request.getParameter("categoria");
		Producto producto = new Producto(nombre, precio, categoria);
		List<Producto> productos;
		HttpSession session = request.getSession();
		
		productos = (ArrayList<Producto>) session.getAttribute("producto");
		productos.add(producto);
		
		//session.setAttribute("producto", productos);
		
		request.getRequestDispatcher("inicio.html").forward(request, response);
	}

}
