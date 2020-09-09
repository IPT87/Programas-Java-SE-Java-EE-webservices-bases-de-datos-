package presentacion.graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.CajeroService;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JVentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private CajeroService cs = new CajeroService();
	private int numeroCuenta;
	private JLabel jlCantidadTransferencia;
	private JButton jbSalir;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public JVentanaPrincipal(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton jbIngresar = new JButton("Ingresar");
		jbIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String insertCantidad = JOptionPane.showInputDialog(JVentanaPrincipal.this, "Cantidad");
					if (insertCantidad != null) {
						double cantidad = Double.parseDouble(insertCantidad);
						cs.ingresar(cantidad, numeroCuenta);
					}
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(JVentanaPrincipal.this, "Cantidad incorrecta!");
				}
			}
		});
		jbIngresar.setBounds(34, 81, 119, 28);
		contentPane.add(jbIngresar);
		
		JButton jbExtraer = new JButton("Extraer");
		jbExtraer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String insertCantidad = JOptionPane.showInputDialog(JVentanaPrincipal.this, "Cantidad");
					if (insertCantidad != null) {
						double cantidad = Double.parseDouble(insertCantidad);
						cs.extraer(cantidad, numeroCuenta);
					}
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(JVentanaPrincipal.this, "Cantidad incorrecta!");
				}
			}
		});
		jbExtraer.setBounds(34, 119, 119, 28);
		contentPane.add(jbExtraer);
		
		JButton jbTransferencia = new JButton("Transferencia");
		jbTransferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String insertCantidad = JOptionPane.showInputDialog(JVentanaPrincipal.this, "Cantidad");
					if (insertCantidad != null) {
						double cantidad = Double.parseDouble(insertCantidad);
						String insertCuenta = JOptionPane.showInputDialog(JVentanaPrincipal.this, "Cuenta destino");
						if (insertCuenta != null) {
							int cuentaDestino = Integer.parseInt(insertCuenta);
							cs.transferencia(numeroCuenta, cuentaDestino, cantidad);
						}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(JVentanaPrincipal.this, "Cantidad o numero de cuenta incorrecto!");
				}
				
			}
		});
		jbTransferencia.setBounds(34, 195, 119, 28);
		contentPane.add(jbTransferencia);
		
		JButton jbMovimientos = new JButton("Movimientos");
		jbMovimientos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String movimientos = "";
				for (int i = 0; i < cs.obtenerMovimientos(numeroCuenta).size(); i++) {
					movimientos += cs.obtenerMovimientos(numeroCuenta).get(i) + "\n";
				}
				JOptionPane.showConfirmDialog(JVentanaPrincipal.this, movimientos, "Movimientos", JOptionPane.CLOSED_OPTION);
			}
		});
		jbMovimientos.setBounds(34, 157, 119, 28);
		contentPane.add(jbMovimientos);
		
		JButton jbObtenerSaldo = new JButton("Saldo");
		jbObtenerSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(JVentanaPrincipal.this, cs.obtenerSaldo(numeroCuenta) + "€", "Saldo", JOptionPane.CLOSED_OPTION);
			}
		});
		jbObtenerSaldo.setBounds(34, 42, 119, 28);
		contentPane.add(jbObtenerSaldo);
		
		jlCantidadTransferencia = new JLabel("Elige operaciòn:");
		jlCantidadTransferencia.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlCantidadTransferencia.setBackground(Color.WHITE);
		jlCantidadTransferencia.setBounds(247, 10, 205, 21);
		contentPane.add(jlCantidadTransferencia);
		
		jbSalir = new JButton("Salir");
		Color c = jbSalir.getBackground();
		jbSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jbSalir.setBackground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jbSalir.setBackground(c);
			}
		});
		jbSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(JVentanaPrincipal.this, "Desea salir", "Ventana salida", JOptionPane.YES_NO_OPTION);
				if (resp == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		jbSalir.setBounds(543, 232, 85, 21);
		contentPane.add(jbSalir);
	}

}
