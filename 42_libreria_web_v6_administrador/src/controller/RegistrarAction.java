package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClientesService;
import service.LibreriaFactory;

/**
 * Servlet implementation class RegistrarAction
 */
@WebServlet("/RegistrarAction")
public class RegistrarAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente=new Cliente(0,request.getParameter("usuario"),
				request.getParameter("password"),
				request.getParameter("email"),
				Integer.parseInt(request.getParameter("telefono")));
		ClientesService clientesService=LibreriaFactory.getClientesService();
		clientesService.registrarCliente(cliente);
		//request.getRequestDispatcher("login.html").forward(request, response);
	}

}

