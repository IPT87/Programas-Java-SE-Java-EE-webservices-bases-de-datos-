package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {
	
	private String url = "http://localhost:8080/05_calculadora_rest/";
	@Autowired
	RestTemplate template;
	
	@Override
	public String sumar(int a, int b) {
		String respuesta = template.getForObject(url + "sumar/{num1}/{num2}", String.class, a, b);
		return respuesta;
	}

	@Override
	public String restar(int a, int b) {
		String respuesta = template.getForObject(url + "restar/{num1}/{num2}", String.class, a, b);
		return respuesta;
	}

	@Override
	public String multiplicar(int a, int b) {
		String respuesta = template.getForObject(url + "multiplicar/{num1}/{num2}", String.class, a, b);
		return respuesta;
	}

}
