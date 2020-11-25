package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@PostMapping(value = "login")
	public String login(@RequestParam("usuario") String usuario, @RequestParam("password") String pwd) {
		if (usuario.equals("admin") && pwd.equals("admin")) {
			return "bienvenida";
		} else {
			return "error";
		}
	}
}
