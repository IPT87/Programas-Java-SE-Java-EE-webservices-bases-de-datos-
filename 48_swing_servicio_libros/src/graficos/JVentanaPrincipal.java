package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Libro;
import service.LibrosService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class JVentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIsbn;
	private LibrosService librosService = new LibrosService();
	private String listaResultado = "";

	/**
	 * Create the frame.
	 */
	public JVentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon img = new ImageIcon("C:\\Users\\MrIbi\\Desktop\\Curso_Java_2020\\open-book.png");
		setIconImage(img.getImage());
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		textArea.setEditable(false);
		contentPane.add(textArea);
		textArea.setBorder(UIManager.getBorder("TextArea.border"));
		textArea.setBounds(12, 10, 446, 194);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("programacion");
		comboBox.addItem("sistemas operativos");
		comboBox.addItem("big data");
		comboBox.addItem("ofimatica");
		comboBox.setBounds(90, 158, 126, 21);
		contentPane.add(comboBox);
		
		JLabel lbInicio = new JLabel("Bienvenido a la libreria!");
		lbInicio.setForeground(new Color(51, 102, 153));
		lbInicio.setFont(new Font("Stencil", Font.BOLD, 26));
		lbInicio.setBounds(105, 30, 376, 34);
		contentPane.add(lbInicio);
		
		JLabel lbElige = new JLabel("Elige libros:");
		lbElige.setForeground(new Color(51, 102, 153));
		lbElige.setFont(new Font("Trebuchet MS", Font.ITALIC, 16));
		lbElige.setBounds(235, 87, 121, 26);
		contentPane.add(lbElige);
		
		JButton btnVerTema = new JButton("Ver");
		btnVerTema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idTema = 0;
				switch (comboBox.getSelectedItem().toString()) {
				case "programacion":
					idTema = 1;
					break;
				case "sistemas operativos":
					idTema = 2;
					break;
				case "big data":
					idTema = 3;
					break;
				case "ofimatica":
					idTema = 4;
					break;
				}
				List<Libro> librosTema = librosService.recuperarPorTema(idTema);
				listaResultado = "";
				for (int i = 0; i < librosTema.size(); i++) {
					listaResultado += "\n" + librosTema.get(i) + "\n" + "-------------------------------------------------------------------------------------------------";
					textArea.setText(listaResultado);
				}
			}
		});
		btnVerTema.setBounds(90, 189, 74, 34);
		contentPane.add(btnVerTema);
		
		JLabel lbTema = new JLabel("Libros por tema");
		lbTema.setFont(new Font("Source Serif Pro Light", Font.BOLD, 14));
		lbTema.setBounds(90, 131, 111, 29);
		contentPane.add(lbTema);
		
		JLabel lbIsbn = new JLabel("Libros por isbn");
		lbIsbn.setFont(new Font("Source Serif Pro Light", Font.BOLD, 14));
		lbIsbn.setBounds(355, 131, 111, 29);
		contentPane.add(lbIsbn);
		
		txtIsbn = new JTextField();
		txtIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIsbn.setColumns(10);
		txtIsbn.setBounds(355, 158, 121, 26);
		contentPane.add(txtIsbn);
		
		JButton btnVerIsbn = new JButton("Ver");
		btnVerIsbn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int isbn = 0;
				
				if (txtIsbn.getText().length() != 0) {
					isbn = Integer.parseInt(txtIsbn.getText());
				}
				
				if (isbn != 0 && librosService.recuperarPorIsbn(isbn) != null) {
					Libro libroIsbn = librosService.recuperarPorIsbn(isbn);
					listaResultado = "";
					listaResultado += "\n" + libroIsbn + "\n" + "-------------------------------------------------------------------------------------------------";
					textArea.setText(listaResultado);
				} else {
					JOptionPane.showConfirmDialog(JVentanaPrincipal.this, "El isbn no existe!", "Informacion", JOptionPane.CLOSED_OPTION);
				}
			}
		});
		btnVerIsbn.setBounds(355, 189, 74, 34);
		contentPane.add(btnVerIsbn);
		
		JLabel lbTodos = new JLabel("Todos los libros");
		lbTodos.setFont(new Font("Source Serif Pro Light", Font.BOLD, 14));
		lbTodos.setBounds(236, 247, 111, 29);
		contentPane.add(lbTodos);
		
		JButton btnVerTodos = new JButton("Ver");
		btnVerTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Libro> todosLibros = librosService.recuperarTodos();
				listaResultado = "";
				for (int i = 0; i < todosLibros.size(); i++) {
					listaResultado += "\n" + todosLibros.get(i) + "\n" + "-------------------------------------------------------------------------------------------------";
					textArea.setText(listaResultado);
				}
			}
		});
		btnVerTodos.setBounds(246, 286, 74, 34);
		contentPane.add(btnVerTodos);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 336, 566, 196);
		contentPane.add(scrollPane);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(491, 566, 85, 21);
		contentPane.add(btnSalir);
		Color c = btnSalir.getBackground();
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSalir.setBackground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSalir.setBackground(c);
			}
		});
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(JVentanaPrincipal.this, "Desea salir", "Ventana salida", JOptionPane.YES_NO_OPTION);
				if (resp == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
	}
}
