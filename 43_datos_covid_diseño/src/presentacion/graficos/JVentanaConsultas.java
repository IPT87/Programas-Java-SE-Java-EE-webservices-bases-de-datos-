package presentacion.graficos;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.CasosService;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import com.toedter.calendar.JCalendar;

import model.Caso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

public class JVentanaConsultas extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JVentanaInicio vi = new JVentanaInicio();
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private CasosService cs = new CasosService("C:\\Users\\MrIbi\\Desktop\\Curso_Java_2020\\datos_ccaas.json");
	private String comunidad;
	private Date f1;
	private Date f2;

	/**
	 * Create the frame.
	 */
	public JVentanaConsultas(String comunidad) {
		this.comunidad = comunidad;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 668, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelCalendars = new JPanel();
		panelCalendars.setVisible(false);
		panelCalendars.setBounds(18, 86, 565, 200);
		contentPane.add(panelCalendars);
		panelCalendars.setLayout(null);
		
		JRadioButton jbTodasFechas = new JRadioButton("Todas fechas");
		jbTodasFechas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jbTodasFechas.isSelected()) {
					panelCalendars.setVisible(false);
				}
			}
		});
		buttonGroup.add(jbTodasFechas);
		jbTodasFechas.setBounds(18, 31, 105, 21);
		contentPane.add(jbTodasFechas);
		
		JRadioButton jbRangoFechas = new JRadioButton("Rango fechas");
		jbRangoFechas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jbRangoFechas.isSelected()) {
					panelCalendars.setVisible(true);
				}
			}
		});
		buttonGroup.add(jbRangoFechas);
		jbRangoFechas.setBounds(18, 66, 105, 21);
		contentPane.add(jbRangoFechas);
		
		JCalendar calendar = new JCalendar();
		JCalendar calendar_1 = new JCalendar();
		
		JButton jbMostrarCasos = new JButton("Mostrar casos");
		jbMostrarCasos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f1 = calendar.getDate();
				f2 = calendar_1.getDate();
				if (jbTodasFechas.isSelected()) {
					Map<String, List<Caso>> casos = cs.casosComunidad(comunidad);
					StringBuilder positivos = new StringBuilder();
					casos.forEach((k, p) -> p.forEach(c -> positivos.append("Casos " + comunidad + ": " + sdf.format(c.getFecha()) + ", " + c.getPositivos() + " casos positivos.\n")));
					JOptionPane.showMessageDialog(JVentanaConsultas.this, positivos);
				}
				if (jbRangoFechas.isSelected()) {
					List<Caso> list = cs.casosPorPeriodo(f1, f2);
					String caso = "0";
					for (int i = 0; i < list.size(); i++) {
						caso += list.get(i) + "\n";
					}
					JOptionPane.showMessageDialog(JVentanaConsultas.this, caso);
				}
			}
		});
		jbMostrarCasos.setBounds(451, 291, 132, 21);
		contentPane.add(jbMostrarCasos);
				
		JLabel jlFechaDesde = new JLabel("Fecha desde");
		jlFechaDesde.setBounds(0, 10, 114, 13);
		panelCalendars.add(jlFechaDesde);
		
		JLabel jlFechaHasta = new JLabel("Fecha hasta");
		jlFechaHasta.setBounds(304, 10, 155, 13);
		panelCalendars.add(jlFechaHasta);
		
				calendar.setBounds(0, 33, 251, 140);
				panelCalendars.add(calendar);
				
				calendar_1.setBounds(304, 33, 251, 140);
				panelCalendars.add(calendar_1);
	}
}
