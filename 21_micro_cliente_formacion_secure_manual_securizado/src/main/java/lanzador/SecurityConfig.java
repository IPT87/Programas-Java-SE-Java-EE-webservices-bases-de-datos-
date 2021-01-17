package lanzador;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{	
	//definición roles y usuarios
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
        .inMemoryAuthentication()
        .withUser("test1")
          .password("{noop}test1") //lo de {noop} se pone para no obligar a usar mecanismo de encriptación
          .roles("USERS")
          .and()
        .withUser("test2")
          .password("{noop}test2")
          .roles("USERS", "OPERATORS");
		
		/*lo siguiente sería para el caso de que
		 * quisiéramos encriptar la password:
		String pw1=new BCryptPasswordEncoder().encode("user1");
		System.out.println(pw1);
		  auth
	        .inMemoryAuthentication()
	        .withUser("user1")
	          .password("{bcrypt}"+pw1)
	          //.password(pw1)
	          .roles("USER")
	          .and()
	        .withUser("admin")
	          .password(new BCryptPasswordEncoder().encode("admin"))
	          .roles("USER", "ADMIN");
		 */
		
		/*la seguiente configuración será para el caso de 
		 * usuarios en una base de datos
		 * auth.jdbcAuthentication().dataSource(dataSource)
        	.usersByUsernameQuery("select username, password, enabled"
            	+ " from users where username=?")
        	.authoritiesByUsernameQuery("select username, authority "
            	+ "from authorities where username=?");
		 */
	}
	//definición de políticas de seguridad
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().
		csrf().disable()
		.authorizeRequests()
		//solo los miembros del rol admin podrán realizar altas
		//y para ver la lista de contactos, tendrán que estar autenticados
		.antMatchers(HttpMethod.GET,"/alumnos/*").hasRole("OPERATORS")
		.antMatchers("/cursos").authenticated()	
		//.antMatchers("/**").authenticated()
		//.antMatchers("/contactos/**").authenticated()
		.and()
		.httpBasic();
	
	}
}
