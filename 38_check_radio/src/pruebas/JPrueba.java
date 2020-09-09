package pruebas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

public class JPrueba extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPrueba frame = new JPrueba();
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
	public JPrueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox ckMonitor = new JCheckBox("Monitor");
		ckMonitor.setBounds(42, 59, 95, 21);
		contentPane.add(ckMonitor);
		
		JCheckBox ckDisco = new JCheckBox("Disco SSD");
		ckDisco.setBounds(42, 121, 95, 21);
		contentPane.add(ckDisco);
		
		JButton jbConfigurar = new JButton("Comprobar");
		jbConfigurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ckMonitor.isSelected()) {
					JOptionPane.showMessageDialog(JPrueba.this, "Monitor");
				}
				if (ckDisco.isSelected()) {
					JOptionPane.showMessageDialog(JPrueba.this, "Disco");
				}
				
				//comprobacion del RadioButton seleccionado
				ButtonModel bmodel = buttonGroup.getSelection();
				String precio = bmodel.getActionCommand();
				JOptionPane.showMessageDialog(JPrueba.this, "Precio de la memoria " + precio);
			}
		});
		jbConfigurar.setBounds(169, 189, 85, 21);
		contentPane.add(jbConfigurar);
		
		JRadioButton rb8gb = new JRadioButton("8 GB");
		rb8gb.setActionCommand("60");
		rb8gb.setMnemonic(KeyEvent.VK_G);
		buttonGroup.add(rb8gb);
		rb8gb.setBounds(251, 59, 105, 21);
		contentPane.add(rb8gb);
		
		JRadioButton rb16gb = new JRadioButton("16 GB");
		rb16gb.setActionCommand("100");
		rb16gb.setMnemonic(KeyEvent.VK_B);
		buttonGroup.add(rb16gb);
		rb16gb.setBounds(251, 97, 105, 21);
		contentPane.add(rb16gb);
	}
}
