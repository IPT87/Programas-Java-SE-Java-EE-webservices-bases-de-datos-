package presentacion.graficos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentacion.adaptadores.TablaContactosModel;
import service.ContactoService;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

public class JVentanaContactos extends JFrame {

	private JPanel contentPane;
	private ContactoService cs = new ContactoService();
	private JTable tableContactos;
	

	/**
	 * Create the frame.
	 */
	public JVentanaContactos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 60, 358, 143);
		contentPane.add(scrollPane);
		
		tableContactos = new JTable(new TablaContactosModel());
		scrollPane.setViewportView(tableContactos);
		
		tableContactos.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				//obtener fila y columna donde se ha hecho el click
				int fila = tableContactos.getSelectedRow();
				int col = tableContactos.getSelectedColumn();
				//recuperamos el contenido de la celda a traves del modelo de datos
				Object dato = tableContactos.getModel().getValueAt(fila, col);
				JOptionPane.showMessageDialog(JVentanaContactos.this, dato.toString());
			}
		});
		
		JLabel lblNewLabel = new JLabel("Tabla de contactos");
		lblNewLabel.setBounds(48, 10, 180, 31);
		contentPane.add(lblNewLabel);
		
	}
}
