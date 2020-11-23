package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import service.CuentasService;

/**
 * Servlet implementation class RetirarAction
 */
@WebServlet("/RetirarAction")
public class RetirarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	CuentasService service;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		//le informa al servidor de aplicaciones que Spring va a realizar inyecci�n
		//de objetos en este servlet
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double cantidad = Double.parseDouble(request.getParameter("cantidad"));
		int numeroCuenta = (int)request.getSession().getAttribute("numeroCuenta");
		request.setAttribute("resultado", service.retirar(cantidad, numeroCuenta));
	}

}
