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

import model.Candidato;
import service.CandidatosService;

/**
 * Servlet implementation class BuscarCandidatos
 */
@WebServlet("/BuscarCandidatosAction")
public class BuscarCandidatosAction extends HttpServlet {
	@Autowired
	CandidatosService service;
	@Override
	public void init(ServletConfig config) throws ServletException {
		//le informa al servidor de aplicaciones que Spring va a realizar inyecci�n
		//de objetos en este servlet
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.init(config);
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Candidato> candidatos = service.recuperarCandidatos();
		
		JSONArray array=new JSONArray();
		candidatos.forEach(item->{
			JSONObject ob=new JSONObject();
			ob.put("idCandidato", item.getIdCandidato());
			ob.put("edad", item.getEdad());
			ob.put("email", item.getEmail());
			ob.put("foto", item.getFoto());
			ob.put("nombre", item.getNombre());
			ob.put("puesto", item.getPuesto());
			array.add(ob);
		});
		response.setContentType("application/json");
		PrintWriter out=response.getWriter();
		out.println(array.toJSONString());
	}

}
