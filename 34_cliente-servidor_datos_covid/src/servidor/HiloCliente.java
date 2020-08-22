package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import service.CasoService;

public class HiloCliente implements Runnable {
	private Socket socket;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static CasoService service = new CasoService("ruta del fichero JSON el que contiene los datos");
	
	public HiloCliente(Socket socket) {
		this.socket=socket;
	}
	
	
	@Override
	public void run() {
		try(OutputStream out = new PrintStream(socket.getOutputStream());
				BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
			String nombre = bf.readLine();
			String respuesta = nombre + ", positivos: " + service.totalPositivos(nombre) + 
					", media de positivos diarios: " + service.totalMediaPositivosDiarios(nombre) + 
					", fecha de pico de contagios: " + sdf.format(service.fechaPicoContagios(nombre)) + ".";
			
			out.write(respuesta.getBytes());
		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
