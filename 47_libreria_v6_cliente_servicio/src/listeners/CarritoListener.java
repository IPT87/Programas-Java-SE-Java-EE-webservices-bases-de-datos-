package listeners;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import model.Libro;

/**
 * Application Lifecycle Listener implementation class CarritoListener
 *
 */
@WebListener
public class CarritoListener implements HttpSessionListener {

    
    public void sessionCreated(HttpSessionEvent se)  { 
         se.getSession().setAttribute("carrito", new ArrayList<Libro>());
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
