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
		case "toInicio":
			url = "inicio.html";
			break;
		case "toMenu":
			url = "menu.html";
			break;
		case "toIngresar":
			url = "ingresar.html";
			break;
		case "toRetirar":
			url = "retirar.html";
			break;
		case "toTransferencia":
			url = "transferencia.html";
			break;
		case "doVerificar":
			request.getRequestDispatcher("VerificarClienteAction").include(request, response);
			url = (boolean)request.getAttribute("resultado") ? "menu.html" : "cuentaNoExistente.html";
			break;
		case "doTransferencia":
			request.getRequestDispatcher("TransferenciaAction").include(request, response);
			url = (boolean)request.getAttribute("resultado") ? "menu.html" : "saldoInsuficiente.html";
			break;
		case "doVerMovimientos":
			request.getRequestDispatcher("VerMovimientosAction").include(request, response);
			url = "verMovimientos.jsp";
			break;
		case "doIngresar":
			request.getRequestDispatcher("IngresarAction").include(request, response);
			url = "menu.html";
			break;
		case "doRetirar":
			request.getRequestDispatcher("RetirarAction").include(request, response);
			url = (boolean)request.getAttribute("resultado") ? "menu.html" : "saldoInsuficiente.html";
			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
