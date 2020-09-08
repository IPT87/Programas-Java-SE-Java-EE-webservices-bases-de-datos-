package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;

import model.PedidoTienda;
import service.GestorPedidosTotales;
import util.Utilidades;

public class HiloAtencionCliente implements Runnable {
	private Socket socket;
	public HiloAtencionCliente(Socket socket) {
		this.socket=socket;
	}
	@Override
	public void run() {
		try(PrintStream out=new PrintStream(socket.getOutputStream());
				BufferedReader bf=new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
			//leemos la información enviada por el cliente
			String tienda=bf.readLine();
			GestorPedidosTotales gestor=new GestorPedidosTotales();
			List<PedidoTienda> pedidos=gestor.recuperarPedidos(tienda);
			//recorremos los pedidos y mandamos uno a uno como cadena
			//o generamos un json con los pedidos y lo mandamos como cadena
			StringBuilder totales=new StringBuilder();
			pedidos.forEach(p->
			{
				totales.append(p.getProducto()+"|");
				totales.append(p.getUnidades()+"|");
				totales.append(p.getPrecioUnitario()+"|");
				totales.append(p.getSeccion()+"|");
				totales.append(Utilidades.formatearFecha(p.getFecha()));
				totales.append(System.lineSeparator());
			});
			out.println(totales.toString());
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

