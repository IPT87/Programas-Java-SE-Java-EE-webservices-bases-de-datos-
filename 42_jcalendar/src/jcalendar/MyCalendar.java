package jcalendar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.demo.DateChooserPanel;
import com.toedter.calendar.demo.DateChooserPanelBeanInfo;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JSlider;

public class MyCalendar extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyCalendar frame = new MyCalendar();
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
	public MyCalendar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(59, 45, 227, 152);
		contentPane.add(calendar);
		
		JButton jbFechas = new JButton("Ver fechas");
		jbFechas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date f1 = calendar.getDate();
				JOptionPane.showMessageDialog(MyCalendar.this, "Fechas " + f1);
			}
		});
		jbFechas.setBounds(101, 215, 111, 21);
		contentPane.add(jbFechas);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(22, 215, 69, 19);
		contentPane.add(dateChooser);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(59, 10, 153, 19);
		contentPane.add(passwordField);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(61, 271, 30, 20);
		contentPane.add(spinner);
		
		JSlider slider = new JSlider();
		slider.setBounds(12, 313, 200, 22);
		contentPane.add(slider);
	}
}
