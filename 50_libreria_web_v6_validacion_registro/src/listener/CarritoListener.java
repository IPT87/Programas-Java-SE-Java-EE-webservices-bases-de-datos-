package listener;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import model.Libro;

/**
 * Application Lifecycle Listener implementation class CarritoListener
 *
 */
@WebListener
public class CarritoListener implements HttpSessionListener, ServletContextListener, ServletRequestListener {

    /**
     * Default constructor. 
     */
    public CarritoListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
        se.getSession().setAttribute("librosCarrito", new ArrayList<Libro>());
   }

	
   public void sessionDestroyed(HttpSessionEvent se)  { 
        // TODO Auto-generated method stub
   }
	
}
