package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorSaludo {

	public static void main(String[] args) {
		System.out.println("Esperando llamadas...");
		ExecutorService service = Executors.newCachedThreadPool();
		try(ServerSocket server = new ServerSocket(8000);) {
			while (true) {
				Socket sc = server.accept();
				System.out.println("Llamada recibida!!");
				service.submit(new HiloAtencionCliente(sc));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
