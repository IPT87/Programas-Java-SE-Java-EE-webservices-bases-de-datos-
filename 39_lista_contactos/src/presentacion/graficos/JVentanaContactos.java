package presentacion.graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Contacto;
import presentacion.adaptadores.ListaContactosModel;
import service.ContactoService;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class JVentanaContactos extends JFrame {

	private JPanel contentPane;
	private ContactoService cs = new ContactoService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JVentanaContactos frame = new JVentanaContactos();
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
	public JVentanaContactos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 55, 322, 145);
		contentPane.add(scrollPane);
		
		JList<Contacto> listContactos = new JList<>(new ListaContactosModel());
		listContactos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int resp = JOptionPane.showConfirmDialog(JVentanaContactos.this, "Desea eliminar el contacto?", "Eliminar", JOptionPane.YES_NO_OPTION);
				if (resp == JOptionPane.YES_OPTION) {
					cs.eliminarContacto(listContactos.getSelectedValue().getEmail());
					listContactos.setModel(new ListaContactosModel());
				}
			}
		});
		scrollPane.setViewportView(listContactos);
		
	}
}
