package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.LibreriaService;
import service.LibreriaServiceFactory;

/**
 * Servlet implementation class Autenticar
 */
@WebServlet("/Autenticar")
public class Autenticar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibreriaService libreriaService = LibreriaServiceFactory.getLibreriaService();
			
		String url;
		
		if (libreriaService.validarCliente(request.getParameter("usuario"), request.getParameter("pass")) != null) {		
            url = "bienvenida.html";            
		} else {	
			url = "error.html";
		}
       
        request.getRequestDispatcher(url).forward(request, response);
	}

}
