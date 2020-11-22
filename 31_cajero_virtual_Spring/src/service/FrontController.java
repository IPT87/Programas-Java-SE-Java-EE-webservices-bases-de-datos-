package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="";
		String option=request.getParameter("option");
		
		switch(option) {
		case "doVerClientes":
			request.getRequestDispatcher("VerClientesAction").include(request, response);
			url="seleccionarCliente.jsp";
			break;
		case "doVerCuentas":
			request.getRequestDispatcher("VerCuentasAction").include(request, response);
			url="seleccionarCuenta.jsp";
			break;
		case "doAsignarCuenta":
			request.getRequestDispatcher("AsignarCuentaAction").include(request, response);
			url="inicio.html";
			break;
		case "toInicio":
			url="inicio.html";
			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
