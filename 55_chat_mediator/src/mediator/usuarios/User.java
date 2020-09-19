package mediator.usuarios;

import mediator.mediador.SalaChat;

public class User implements UserChat {
	private String name;
	private SalaChat sala;
	public User(SalaChat sala, String name) {
		this.sala=sala;
		this.name=name;
		sala.registrar(this);
	}
	
	@Override
	public void enviar(String destinatario, String mensaje) {
		sala.enviarMensaje(name, destinatario, mensaje);
	}

	@Override
	public void recibir(String remitente, String mensaje) {
		System.out.println("Recibido "+mensaje+" desde "+remitente);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SalaChat getSala() {
		return sala;
	}

	public void setSala(SalaChat sala) {
		this.sala = sala;
	}

}
