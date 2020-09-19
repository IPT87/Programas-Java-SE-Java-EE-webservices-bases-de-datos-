package presentacion.graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.CasosService;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import com.toedter.calendar.JCalendar;
import java.awt.Font;

public class JVentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private String fuente;
	private String comunidad;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private CasosService cs = new CasosService("C:\\Users\\MrIbi\\Desktop\\Curso_Java_2020\\datos_ccaas.json");

	/**
	 * Create the frame.
	 */
	public JVentanaPrincipal(String fuente) {
		this.fuente = fuente;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 351);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
		
		JMenu mnPorComunidad = new JMenu("Por comunidad");
		mnConsultas.add(mnPorComunidad);
		
		JLabel lblNewLabel = new JLabel("Andalucia");
		Color c = lblNewLabel.getBackground();
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setBackground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setBackground(c);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				comunidad = lblNewLabel.getText();
				JVentanaConsultas frame = new JVentanaConsultas(comunidad);
				frame.setVisible(true);
			}
		});
		mnPorComunidad.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Aragon");
		mnPorComunidad.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Asturias");
		mnPorComunidad.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Canarias");
		mnPorComunidad.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cantabria");
		mnPorComunidad.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Castilla La Mancha");
		mnPorComunidad.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Castilla y Leon");
		mnPorComunidad.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Cataluña");
		mnPorComunidad.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Extremadura");
		mnPorComunidad.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Galicia");
		mnPorComunidad.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Islas Baleares");
		mnPorComunidad.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("La Rioja");
		mnPorComunidad.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Madrid");
		mnPorComunidad.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Murcia");
		mnPorComunidad.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Navarra");
		mnPorComunidad.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Pais Vasco");
		mnPorComunidad.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Valenciana");
		mnPorComunidad.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Ceuta");
		mnPorComunidad.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Melilla");
		mnPorComunidad.add(lblNewLabel_18);
		
		JMenu mnEstadisticas = new JMenu("Estadisticas");
		menuBar.add(mnEstadisticas);
		
		JMenu mnInformes = new JMenu("Informes");
		mnEstadisticas.add(mnInformes);
		
		JPanel panelCalendar = new JPanel();
		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 47, 227, 152);
		
		JMenuItem mntmContagiosDiarios = new JMenuItem("Media contagios diarios");
		mntmContagiosDiarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCalendar.setVisible(true);
			}
		});
		mnInformes.add(mntmContagiosDiarios);
		
		JMenuItem mntmPicoContagios = new JMenuItem("Fecha pico contagios");
		mntmPicoContagios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(JVentanaPrincipal.this, "Fecha: " + sdf.format(cs.fechaPicoContagios()));
			}
		});
		mnInformes.add(mntmPicoContagios);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton jbSalir = new JButton("Salir");
		Color cl = jbSalir.getBackground();
		jbSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jbSalir.setBackground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jbSalir.setBackground(cl);
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
		jbSalir.setBounds(421, 261, 85, 21);
		contentPane.add(jbSalir);
		
		panelCalendar.setVisible(false);
		panelCalendar.setBounds(138, 38, 263, 244);
		contentPane.add(panelCalendar);
		panelCalendar.setLayout(null);
		
		panelCalendar.add(calendar);
		
		JButton jbMostrarDatos = new JButton("Mostrar datos");
		jbMostrarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(JVentanaPrincipal.this, cs.totalMediaPositivosDiarios(calendar.getDate()));
				panelCalendar.setVisible(false);
			}
		});
		jbMostrarDatos.setBounds(108, 213, 129, 21);
		panelCalendar.add(jbMostrarDatos);
		
		JLabel jlElegirFecha = new JLabel("Elige fecha:");
		jlElegirFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		jlElegirFecha.setBounds(10, 10, 191, 27);
		panelCalendar.add(jlElegirFecha);
		
	}

	public String getFuente() {
		return fuente;
	}
}
