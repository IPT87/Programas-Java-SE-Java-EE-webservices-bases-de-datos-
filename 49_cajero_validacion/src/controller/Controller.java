package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		String url = "inicio.html";
		
		switch (option) {
		case "doEntrar":
			request.getRequestDispatcher("EntrarAction").include(request, response);
			url = (Boolean)request.getAttribute("verificarCuenta") ? "menu.html" : "error.html";
			break;
		case "toInicio":
			url = "inicio.html";
			break;
		case "toIngresar":
			url = "ingresar.html";
			break;
		case "doIngresar":
			request.getRequestDispatcher("IngresarAction").include(request, response);
			url = "menu.html";
			break;
		case "toExtraer":
			url = "extraer.html";
			break;
		case "doExtraer":
			request.getRequestDispatcher("ExtraerAction").include(request, response);
			url = "menu.html";
			break;
		case "toTransferencia":
			url = "transferencia.html";
			break;
		case "doTransferencia":
			request.getRequestDispatcher("TransferenciaAction").include(request, response);
			url = "menu.html";
			break;
		case "doMovimientos":
			request.getRequestDispatcher("MovimientosAction").include(request, response);
			url = "movimientos.jsp";
			break;
		case "toMenu":
			url = "menu.html";
			break;
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
