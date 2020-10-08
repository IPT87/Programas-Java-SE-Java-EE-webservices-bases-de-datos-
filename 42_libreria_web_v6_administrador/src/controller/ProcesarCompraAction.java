package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exceptions.SinLibrosException;
import model.Cliente;
import model.Libro;
import service.LibreriaFactory;
import service.VentasService;

/**
 * Servlet implementation class ProcesarCompraAction
 */
@WebServlet("/ProcesarCompraAction")
public class ProcesarCompraAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VentasService ventasService=LibreriaFactory.getVentasService();
		HttpSession sesion= request.getSession();
		List<Libro> carrito=(List<Libro>)sesion.getAttribute("carrito");
		request.setAttribute("resultado", true);
		try {
			ventasService.nuevaVenta((Cliente)sesion.getAttribute("cliente"), 
					carrito);
		} catch (SinLibrosException e) {
			request.setAttribute("resultado", false);
			HashMap<String,String> datos=new HashMap<>();
			datos.put("SinLibrosException", e.getMessage());
			request.setAttribute("errores", datos);
		}
		carrito.clear();//vaciar el carrito
		
	}

}

