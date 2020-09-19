package presentacion.graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.CajeroFactory;
import service.CajeroService;
import service.Datos;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JVentanaInicio extends JFrame {

	private JPanel contentPane;
	private JTextField tfCuenta;
	private JButton jbEntrar;
	private CajeroService cs = CajeroFactory.getFactory(0).getCajeroService();

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

	/**
	 * Create the frame.
	 */
	public JVentanaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfCuenta = new JTextField();
		tfCuenta.setBounds(114, 108, 190, 33);
		contentPane.add(tfCuenta);
		tfCuenta.setColumns(10);
		
		JLabel jlPedirCuenta = new JLabel("Introduce numero de cuenta");
		jlPedirCuenta.setBounds(132, 56, 165, 22);
		contentPane.add(jlPedirCuenta);
		
		jbEntrar = new JButton("Entrar");
		jbEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cs.recuperarCuenta(Integer.parseInt(tfCuenta.getText())) == null) {
					JOptionPane.showConfirmDialog(JVentanaInicio.this, "La cuenta no existe!", "Informacion", JOptionPane.CLOSED_OPTION);
					JVentanaInicio.this.dispose();
				} else {
					JVentanaPrincipal frame = new JVentanaPrincipal(Integer.parseInt(tfCuenta.getText()));
					frame.setVisible(true);
					JVentanaInicio.this.dispose();
				}
			}
		});
		jbEntrar.setBounds(158, 183, 85, 21);
		contentPane.add(jbEntrar);
	}
	
}
