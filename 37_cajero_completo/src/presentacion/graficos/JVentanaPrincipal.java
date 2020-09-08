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

public class JVentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private CajeroService cs = new CajeroService();
	private int numeroCuenta;
	private JTextField tfCantidadIngresar;
	private JTextField tfCantidadExtraer;
	private JTextField tfTransferencia;
	private JLabel jlCantidadIngresar;
	private JLabel jlCantidadExtraer;
	private JLabel jlCantidadTransferencia;
	private JTextField tfCuentaDestino;
	private JLabel jlCuentaDestino;
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
				double cantidad = Double.parseDouble(tfCantidadIngresar.getText());
				cs.ingresar(cantidad, numeroCuenta);
				tfCantidadIngresar.setText("");
			}
		});
		jbIngresar.setBounds(34, 66, 119, 28);
		contentPane.add(jbIngresar);
		
		JButton jbExtraer = new JButton("Extraer");
		jbExtraer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double cantidad = Double.parseDouble(tfCantidadExtraer.getText());
				cs.extraer(cantidad, numeroCuenta);
				tfCantidadExtraer.setText("");
			}
		});
		jbExtraer.setBounds(235, 66, 119, 28);
		contentPane.add(jbExtraer);
		
		JButton jbTransferencia = new JButton("Transferencia");
		jbTransferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double cantidad = Double.parseDouble(tfTransferencia.getText());
				int cuentaDestino = Integer.parseInt(tfCuentaDestino.getText());
				cs.transferencia(numeroCuenta, cuentaDestino, cantidad);
				tfTransferencia.setText("");
				tfCuentaDestino.setText("");
			}
		});
		jbTransferencia.setBounds(437, 157, 119, 28);
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
		jbObtenerSaldo.setBounds(235, 157, 119, 28);
		contentPane.add(jbObtenerSaldo);
		
		tfCantidadIngresar = new JTextField();
		tfCantidadIngresar.setBounds(34, 37, 119, 19);
		contentPane.add(tfCantidadIngresar);
		tfCantidadIngresar.setColumns(10);
		
		tfCantidadExtraer = new JTextField();
		tfCantidadExtraer.setColumns(10);
		tfCantidadExtraer.setBounds(235, 37, 119, 19);
		contentPane.add(tfCantidadExtraer);
		
		tfTransferencia = new JTextField();
		tfTransferencia.setColumns(10);
		tfTransferencia.setBounds(437, 37, 119, 19);
		contentPane.add(tfTransferencia);
		
		jlCantidadIngresar = new JLabel("Cantidad");
		jlCantidadIngresar.setBounds(75, 10, 78, 13);
		contentPane.add(jlCantidadIngresar);
		
		jlCantidadExtraer = new JLabel("Cantidad");
		jlCantidadExtraer.setBounds(276, 14, 78, 13);
		contentPane.add(jlCantidadExtraer);
		
		jlCantidadTransferencia = new JLabel("Cantidad");
		jlCantidadTransferencia.setBounds(478, 14, 78, 13);
		contentPane.add(jlCantidadTransferencia);
		
		tfCuentaDestino = new JTextField();
		tfCuentaDestino.setColumns(10);
		tfCuentaDestino.setBounds(437, 97, 119, 19);
		contentPane.add(tfCuentaDestino);
		
		jlCuentaDestino = new JLabel("Cuenta destino");
		jlCuentaDestino.setBounds(463, 74, 93, 13);
		contentPane.add(jlCuentaDestino);
		
		jbSalir = new JButton("Salir");
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
