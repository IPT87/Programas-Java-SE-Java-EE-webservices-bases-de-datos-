package mediator.usuarios;

public interface UserChat {
	void enviar(String destinatario, String mensaje);
	void recibir(String remitente, String mensaje);
}
