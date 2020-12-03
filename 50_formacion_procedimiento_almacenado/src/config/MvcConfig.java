package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackages = {"controller"})
@Configuration
public class MvcConfig implements WebMvcConfigurer{

	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/toAltaAlumno").setViewName("altaalumno");
	    registry.addViewController("/toAltaCurso").setViewName("altacurso");
	    registry.addViewController("/toMenu").setViewName("menu");
	    registry.addViewController("/toMatriculas").setViewName("matriculas");
	    registry.addViewController("/").setViewName("menu");
	    registry.addViewController("/login").setViewName("login");
	 }
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/*").addResourceLocations("/");
    }
}
