package config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiTemplate;

@ComponentScan(basePackages = {"service"})
@Configuration
@PropertySource("classpath:application.properties")
public class SpringConfig {
	
	@Value("${gestion.candidatos.driver}")
	String driver;
	@Value("${gestion.candidatos.url}")
	String url;
	@Value("${gestion.candidatos.user}")
	String usuario;
	@Value("${gestion.candidatos.pwd}")
	String pwd;
	
	private DataSource crearDataSource() {
		DriverManagerDataSource data = new DriverManagerDataSource();
		data.setDriverClassName(driver);
		data.setUrl(url);
		data.setUsername(usuario);
		data.setPassword(pwd);
		return data;
	}
	
	/*private DataSource crearDataSource() {
        DataSource dataSource = null;
        JndiTemplate jndi = new JndiTemplate();
        try {
            dataSource = jndi.lookup("java:comp/env/refempresa", DataSource.class);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return dataSource;
    }*/

	
	@Bean
	public JdbcTemplate crearTemplate() {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(crearDataSource());
		return template;
	}
}
