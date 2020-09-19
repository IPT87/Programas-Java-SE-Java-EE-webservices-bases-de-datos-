package presentacion.graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JVentana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNumero1;
	private JLabel jlNumero2;
	private JTextField tfNumero2;
	private JButton jbMultiplicar;
	private JButton jbRestar;
	private JButton jbSumar;
	private JLabel jlResultado;
	private JButton jbSalir;

	/**
	 * Create the frame.
	 */
	public JVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel jlNumero1 = new JLabel("Numero 1");
		jlNumero1.setBounds(29, 23, 86, 24);
		contentPane.add(jlNumero1);
		
		JButton jbDividir = new JButton("dividir");
		jbDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1 = Integer.parseInt(tfNumero1.getText());
				int num2 = Integer.parseInt(tfNumero2.getText());
				int resultado = num1 / num2;
				jlResultado.setText(String.valueOf(num1) + " / " + String.valueOf(num2) + " = " + String.valueOf(resultado));
			}
		});
		jbDividir.setBounds(246, 111, 103, 33);
		contentPane.add(jbDividir);
		
		tfNumero1 = new JTextField();
		tfNumero1.setBounds(145, 23, 103, 29);
		contentPane.add(tfNumero1);
		tfNumero1.setColumns(10);
		
		jlNumero2 = new JLabel("Numero 2");
		jlNumero2.setBounds(29, 74, 86, 13);
		contentPane.add(jlNumero2);
		
		tfNumero2 = new JTextField();
		tfNumero2.setBounds(145, 62, 103, 28);
		contentPane.add(tfNumero2);
		tfNumero2.setColumns(10);
		
		jbMultiplicar = new JButton("multiplicar");
		jbMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1 = Integer.parseInt(tfNumero1.getText());
				int num2 = Integer.parseInt(tfNumero2.getText());
				int resultado = num1 * num2;
				jlResultado.setText(String.valueOf(num1) + " * " + String.valueOf(num2) + " = " + String.valueOf(resultado));
			}
		});
		jbMultiplicar.setBounds(70, 111, 103, 33);
		contentPane.add(jbMultiplicar);
		
		jbRestar = new JButton("restar");
		jbRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1 = Integer.parseInt(tfNumero1.getText());
				int num2 = Integer.parseInt(tfNumero2.getText());
				int resultado = num1 - num2;
				jlResultado.setText(String.valueOf(num1) + " - " + String.valueOf(num2) + " = " + String.valueOf(resultado));
			}
		});
		jbRestar.setBounds(70, 154, 103, 33);
		contentPane.add(jbRestar);
		
		jbSumar = new JButton("sumar");
		jbSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1 = Integer.parseInt(tfNumero1.getText());
				int num2 = Integer.parseInt(tfNumero2.getText());
				int resultado = num1 + num2;
				jlResultado.setText(String.valueOf(num1) + " + " + String.valueOf(num2) + " = " + String.valueOf(resultado));
			}
		});
		jbSumar.setBounds(246, 154, 103, 33);
		contentPane.add(jbSumar);
		
		jlResultado = new JLabel("resultado");
		jlResultado.setBounds(170, 196, 142, 34);
		contentPane.add(jlResultado);
		
		jbSalir = new JButton("salir");
		jbSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new JDialog() para que salga al centro de la pantalla (el padre es la ventana principal)
				int resp = JOptionPane.showConfirmDialog(JVentana.this, "Desea salir", "Ventana salida", JOptionPane.YES_NO_OPTION);
				if (resp == JOptionPane.YES_OPTION) {
					//JVentana.this.dispose();
					System.exit(0); //Finaliza la aplicaciòn Java
				}
			}
		});
		jbSalir.setBounds(341, 232, 85, 21);
		contentPane.add(jbSalir);
	}
}
