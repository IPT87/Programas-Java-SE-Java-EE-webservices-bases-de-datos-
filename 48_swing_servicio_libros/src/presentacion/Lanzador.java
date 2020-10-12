package presentacion;

import java.awt.EventQueue;

import graficos.JVentanaInicio;

public class Lanzador {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JVentanaInicio frame = new JVentanaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
