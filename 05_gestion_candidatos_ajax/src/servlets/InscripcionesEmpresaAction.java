package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import model.Inscripcion;
import service.InscripcionesService;

/**
 * Servlet implementation class BuscarCandidatos
 */
@WebServlet("/InscripcionesEmpresaAction")
public class InscripcionesEmpresaAction extends HttpServlet {
	@Autowired
	InscripcionesService service;
	@Override
	public void init(ServletConfig config) throws ServletException {
		//le informa al servidor de aplicaciones que Spring va a realizar inyección
		//de objetos en este servlet
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("inscripciones", service.obtenerInscripcionesEmpresa(request.getParameter("empresa")));
		//request.getRequestDispatcher("candidatos.jsp").forward(request, response);
		List<Inscripcion> inscripciones=service.obtenerInscripcionesEmpresa(request.getParameter("empresa"));
		//transformamos la lista a un array JSON y se lo enviamos al cliente
		//transformamos la lista de items en un array JSON y se lo enviamos al cliente
		JSONArray array=new JSONArray();
		inscripciones.forEach(item->{
			JSONObject ob=new JSONObject();
			ob.put("empresa", item.getEmpresa());
			ob.put("posicion", item.getPosicion());
			ob.put("salario", item.getSalario());
			ob.put("empleado", item.getCandidato().getNombre());
			array.add(ob);
		});
		response.setContentType("application/json");
		PrintWriter out=response.getWriter();
		out.println(array.toJSONString());
	}

}
