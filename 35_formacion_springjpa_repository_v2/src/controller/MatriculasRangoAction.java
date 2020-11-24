package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import service.MatriculasService;

/**
 * Servlet implementation class MatriculasRangoAction
 */
@WebServlet("/MatriculasRangoAction")
public class MatriculasRangoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	MatriculasService service;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//le informa al servidor de aplicaciones que Spring va a realizar inyecci�n
		//de objetos en este servlet
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicio = null;
		Date fechaFin = null;
		try {
			fechaInicio = sdf.parse(request.getParameter("fechaInicio"));
			fechaFin = sdf.parse(request.getParameter("fechaFin"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("matriculasRango", service.matriculasRangoFecha(fechaInicio, fechaFin));
	}

}
