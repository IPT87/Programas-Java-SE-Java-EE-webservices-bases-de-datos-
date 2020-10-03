package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroControlLogin
 */
@WebFilter("/*")
public class FiltroControlLogin implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//recuperamos la dirección original solicitada y si quiere autenticarse
		//le dejamos pasar
		String path = ((HttpServletRequest)request).getServletPath();
		String param = ((HttpServletRequest)request).getParameter("option");
		
		if(path.equals("/") || (path.equals("/Controller") && param.equals("doLogin"))) {
			chain.doFilter(request, response);
		}
		
		//comprobamos la existencia del atributo de sesión "cliente"
		//si no existe, le mandamos a Inicio
		HttpSession sesion = ((HttpServletRequest)request).getSession();
		if(sesion.getAttribute("cliente") != null) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("login.html").forward(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
