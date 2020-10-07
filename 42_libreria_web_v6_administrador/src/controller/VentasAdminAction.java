package controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Venta;
import service.VentasService;

/**
 * Servlet implementation class VentasAdminAction
 */
@WebServlet("/VentasAdminAction")
public class VentasAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Inject
	VentasService ventasService;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Venta> ventas = ventasService.recuperarVentas();
		request.setAttribute("ventas", ventas);
	}

}
