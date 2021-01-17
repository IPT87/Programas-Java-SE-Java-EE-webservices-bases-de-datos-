package lanzador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = {"controller", "service"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public RestTemplate template() {
		RestTemplate template = new RestTemplate();
		// Crear interceptor
		BasicAuthenticationInterceptor interceptor = new BasicAuthenticationInterceptor("user1", "user1");
		// Asociar interceptor a RestTemplate
		template.getInterceptors().add(interceptor);
		return template;
	}

}
