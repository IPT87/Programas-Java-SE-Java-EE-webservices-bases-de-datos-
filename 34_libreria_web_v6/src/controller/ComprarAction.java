package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;
import model.Libro;
import service.LibreriaFactory;
import service.VentasService;

/**
 * Servlet implementation class ComprarAction
 */
@WebServlet("/ComprarAction")
public class ComprarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		List<Libro> libros = (ArrayList<Libro>) session.getAttribute("librosCarrito");
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		boolean resultadoVenta = false;
		
		VentasService ventasService = LibreriaFactory.getVentasService();
		
		for (int i = 0; i < libros.size(); i++) {
			if (ventasService.procesarCompra(cliente, libros.get(i))) {
				resultadoVenta = true;
			} else {
				resultadoVenta = false;
				break;
			}
		}
		
		if (resultadoVenta) {
			libros.clear();
		}
		
		request.setAttribute("resultadoVenta", resultadoVenta);
	}

}
