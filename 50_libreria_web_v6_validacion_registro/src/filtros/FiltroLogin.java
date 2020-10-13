package filtros;

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
 * Servlet Filter implementation class FiltroLogin
 */
@WebFilter({ "*.jsp" })
public class FiltroLogin implements Filter {

    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession sesion = ((HttpServletRequest) request).getSession();
		//si el metodo isNew devuelve true, la sesion se acaba de crear, por tanto el usuario
		//que ha entrado no tenia sesion
		if(sesion.getAttribute("cliente") == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
