package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class Inicializador implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		  // Crea el contexto raíz de la aplicación Web
	      AnnotationConfigWebApplicationContext rootContext =
	      new AnnotationConfigWebApplicationContext();
	      //registro de la clase de configuración del modelo
	      rootContext.register(SpringConfig.class);   
	      // Gestiona el ciclo de vida del contexto de aplicación
	      servletContext.addListener(new ContextLoaderListener(rootContext));

	}

}
