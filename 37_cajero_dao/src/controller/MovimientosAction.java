package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cuenta;
import model.Movimiento;
import service.CajeroService;
import service.CajeroServiceFactory;

/**
 * Servlet implementation class MovimientosAction
 */
@WebServlet("/MovimientosAction")
public class MovimientosAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CajeroService cajeroService = CajeroServiceFactory.getCajeroService();
		HttpSession session = request.getSession();
		List<Movimiento> movimientos = cajeroService.obtenerMovimientos(((Cuenta)session.getAttribute("cuenta")).getNumeroCuenta());
		request.setAttribute("movimientos", movimientos);
	}

}
