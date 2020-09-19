package mediator.mediador;

import java.util.HashMap;

import mediator.usuarios.User;

public class Sala implements SalaChat {
	HashMap<String,User> usuarios=new HashMap<>();
	
	@Override
	public void enviarMensaje(String from, String to, String msg) {
		User destino=usuarios.get(to);
		if(destino!=null) {
			destino.recibir(from, msg);
		}

	}

	@Override
	public void registrar(User user) {
		usuarios.put(user.getName(), user);
	}

}
