package presentacion.graficos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JVentanaInicio extends JFrame {

	private JPanel contentPane;
	private JTextField tfFuenteDatos;
	private String fuente;

	/**
	 * Create the frame.
	 */
	public JVentanaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jlInicio = new JLabel("Introduce la ruta de la fuente de datos:");
		jlInicio.setFont(new Font("Tahoma", Font.BOLD, 16));
		jlInicio.setBounds(158, 32, 487, 20);
		contentPane.add(jlInicio);
		
		tfFuenteDatos = new JTextField();
		tfFuenteDatos.setBounds(10, 69, 685, 19);
		contentPane.add(tfFuenteDatos);
		tfFuenteDatos.setColumns(10);
		
		JButton jbIntro = new JButton("Introducir");
		jbIntro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fuente = tfFuenteDatos.getText();
				JVentanaPrincipal frame = new JVentanaPrincipal(fuente);
				frame.setVisible(true);
				JVentanaInicio.this.dispose();
			}
		});
		jbIntro.setBounds(586, 155, 109, 31);
		contentPane.add(jbIntro);
	}

	public String getFuente() {
		return fuente;
	}
}
