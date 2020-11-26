package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import model.Curso;
import service.CursosService;

/**
 * Servlet implementation class AltaCursoAction
 */
@WebServlet("/AltaCursoAction")
public class AltaCursoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	CursosService service;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//le informa al servidor de aplicaciones que Spring va a realizar inyección
		//de objetos en este servlet
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String fechaInicio=request.getParameter("fechaInicio");
			String nombre=request.getParameter("nombre");
			int duracion =Integer.parseInt(request.getParameter("duracion"));
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			Curso curso=new Curso(0,duracion,format.parse(fechaInicio),nombre);
			service.altaCurso(curso);
		}
		catch(ParseException ex) {
			ex.printStackTrace();
		}
		
	}

}
