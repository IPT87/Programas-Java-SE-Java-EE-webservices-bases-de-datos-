package graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.AutenticarService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class JVentanaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private AutenticarService autenticarService = new AutenticarService();
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public JVentanaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon img = new ImageIcon("C:\\Users\\MrIbi\\Desktop\\Curso_Java_2020\\open-book.png");
		setIconImage(img.getImage());
		
		JLabel lblPaginaAutenticacion = new JLabel("Página de autenticación");
		lblPaginaAutenticacion.setFont(new Font("Verdana", Font.BOLD, 22));
		lblPaginaAutenticacion.setBounds(10, 29, 314, 38);
		contentPane.add(lblPaginaAutenticacion);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuario.setBounds(10, 77, 78, 21);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtUsuario.setBounds(10, 108, 279, 26);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblPass = new JLabel("Contraseña:");
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPass.setBounds(10, 155, 116, 21);
		contentPane.add(lblPass);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (autenticarService.validarCliente(txtUsuario.getText(), passwordField.getText())) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								JVentanaPrincipal frame = new JVentanaPrincipal();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					JVentanaInicio.this.dispose();
				} else {
					JOptionPane.showConfirmDialog(JVentanaInicio.this, "El usuario no existe!", "Informacion", JOptionPane.CLOSED_OPTION);
				}
			}
		});
		btnEntrar.setBounds(10, 242, 85, 38);
		contentPane.add(btnEntrar);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordField.setBounds(10, 186, 279, 29);
		contentPane.add(passwordField);
	}
}
