package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@PostMapping(value = "doLogin")
	public String login(@RequestParam("usuario") String usuario, @RequestParam("password") String pwd, HttpSession sesion) {
		if (usuario.equals("admin") && pwd.equals("admin")) {
			sesion.setAttribute("usuario", usuario);
			return "buscador";
		} else {
			return "error";
		}
	}
}
