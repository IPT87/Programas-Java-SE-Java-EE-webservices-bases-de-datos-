package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.Tema;
import service.ClientesService;
import service.LibreriaFactory;



@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url;
		ClientesService clientesService=LibreriaFactory.getClientesService();
		Cliente cliente=clientesService.validarCliente(request.getParameter("user"),request.getParameter("pwd"));
		if(cliente!=null){
			
            /*List<Tema> temas=LibreriaFactory
            	.getTemasService()
            	.obtenerTemas();
            request.setAttribute("temas", temas);*/
			//llamamos al TemasAction, que ya se encarga de recoger los temas
			//y ponerlos a disposición de la JSP
			request.getRequestDispatcher("TemasAction").include(request, response);
			request.setAttribute("resultado", true);
            request.getSession().setAttribute("cliente", cliente);

		} else{	
			request.setAttribute("resultado", false);
		}
            
	}
	
}
