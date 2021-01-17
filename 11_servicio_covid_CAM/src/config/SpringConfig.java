package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = {"service"})
@Configuration
public class SpringConfig {
	
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
	
}
