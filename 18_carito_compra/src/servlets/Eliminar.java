package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Producto;

/**
 * Servlet implementation class Eliminar
 */
@WebServlet("/Eliminar")
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Producto> productos = (List<Producto>) session.getAttribute("producto");
		
		if (productos != null) {
			int pos = Integer.parseInt(request.getParameter("posicion"));
			productos.remove(productos.get(pos));
		}
		
		session.setAttribute("producto", productos);
		
		request.getRequestDispatcher("verProductos.jsp").forward(request, response);
	}

}
