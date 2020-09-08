package presentacion.graficos;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JVentana extends JFrame {
	public JVentana() {
		//1. Titulo ventana
		super("Primera ventana");
		//2. Tamaño y posiciòn
		this.setBounds(200, 100, 700, 400);
		this.setBackground(Color.DARK_GRAY);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		iniciarComponentes();
		//3. Visualizar
		this.setVisible(true);
	}
	
	private void iniciarComponentes() {
		//Eliminar el gestor de organizaciòn(layout)
		this.setLayout(null);
		//Crear y configurar controles
		JButton jb1 = new JButton("Pulsar aqui");
		jb1.setBounds(60, 20, 150, 40);
		JButton jb2 = new JButton("Salir");
		jb2.setBounds(60, 70, 150, 40);
		JLabel jl1 = new JLabel("Pasa por encima");
		jl1.setBounds(60, 120, 150, 40);
		jl1.setOpaque(true);
		jl1.setBackground(Color.red);
		//Añadir el control al contenedor
		this.add(jb1);
		this.add(jb2);
		this.add(jl1);
		
		//gestion de eventos
		//1. Creamos implementacion de manejador
		ActionListener listener1 = e -> jb1.setText("Ha pulsado");
		ActionListener listener2 = e -> this.dispose();
		// Creamos una clase anonima
		/*MouseListener listener3 = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				jl1.setBackground(Color.RED);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				jl1.setBackground(Color.BLUE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		};*/
		MouseListener listener3 = new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				jl1.setBackground(Color.BLUE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jl1.setBackground(Color.RED);
			}
			
		};
		//2. Asociamos manejador a evento de una fuente
		jb1.addActionListener(listener1);
		jb2.addActionListener(listener2);
		jl1.addMouseListener(listener3);
	}
	
}
