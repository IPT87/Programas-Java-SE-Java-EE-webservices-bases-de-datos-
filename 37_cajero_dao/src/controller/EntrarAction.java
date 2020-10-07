package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cuenta;
import service.CajeroService;
import service.CajeroServiceFactory;

/**
 * Servlet implementation class EntrarAction
 */
@WebServlet("/EntrarAction")
public class EntrarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CajeroService cajeroService = CajeroServiceFactory.getCajeroService();
		Cuenta cuenta = cajeroService.recuperarCuenta(Integer.parseInt(request.getParameter("numCuenta")));
		
		if(cuenta != null) {
			request.setAttribute("verificarCuenta", true);
            request.getSession().setAttribute("cuenta", cuenta);
		} else {
			request.setAttribute("verificarCuenta", false);
		}
	}

}
