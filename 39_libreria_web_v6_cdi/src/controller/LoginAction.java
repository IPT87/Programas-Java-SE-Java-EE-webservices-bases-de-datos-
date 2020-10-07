package controller;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClientesService;



@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	ClientesService clientesService;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String url;
		Cliente cliente = clientesService.validarCliente(request.getParameter("user"),request.getParameter("pwd"));
		if(cliente != null) {
			
            /*List<Tema> temas=LibreriaFactory
            	.getTemasService()
            	.obtenerTemas();
            request.setAttribute("temas", temas);*/
			//llamamos al TemasAction, que ya se encarga de recoger los temas
			//y ponerlos a disposición de la JSP
			request.getRequestDispatcher("TemasAction").include(request, response);
			request.setAttribute("resultado", true);
            request.getSession().setAttribute("cliente", cliente);

		} else {	
			request.setAttribute("resultado", false);
		}
            
	}
	
}
