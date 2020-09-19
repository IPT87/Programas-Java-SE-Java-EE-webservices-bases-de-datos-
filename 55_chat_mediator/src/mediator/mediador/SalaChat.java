package mediator.mediador;

import mediator.usuarios.User;

public interface SalaChat {
	
	void registrar(User user);
	void enviarMensaje(String from, String to, String msg);
}