package servlets;

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

import model.Curso;
import service.FormacionService;

/**
 * Servlet implementation class AltaCursoAction
 */
@WebServlet("/AltaCursoAction")
public class AltaCursoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	FormacionService service;

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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		
		try {
			fecha = sdf.parse(request.getParameter("fechaInicio"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Curso curso = new Curso(0,
						Integer.parseInt(request.getParameter("duracion")),
						fecha,
						request.getParameter("curso"));
		
		service.altaCurso(curso);
	}

}
