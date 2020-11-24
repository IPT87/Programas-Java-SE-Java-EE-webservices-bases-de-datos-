package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import model.Alumno;
import service.AlumnosService;

/**
 * Servlet implementation class AltaAlumnoAction
 */
@WebServlet("/AltaAlumnoAction")
public class AltaAlumnoAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	AlumnosService service;
	@Override
	public void init(ServletConfig config) throws ServletException {
		//le informa al servidor de aplicaciones que Spring va a realizar inyecci�n
		//de objetos en este servlet
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario=request.getParameter("usuario");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String nombre=request.getParameter("nombre");
		int edad=Integer.parseInt(request.getParameter("edad"));
		if(service.buscarAlumnoPorUsuario(usuario)==null) {
			Alumno alumno=new Alumno(usuario, edad, email, nombre, password);
			service.altaAlumno(alumno);
			request.setAttribute("resultado", true);
		}else {
			request.setAttribute("resultado", false);
		}
	}

}
