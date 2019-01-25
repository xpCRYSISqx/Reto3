package vista;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;

public class SelecLinea extends JPanel {

	/**
	 * Create the panel.
	 */
	public SelecLinea() {
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"L1: Termibus - Plentzia", "L2: Termibus - Muskiz", "L3: Termibus - Balmaseda", "L4: Termibus - Durango"}));
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(61, 112, 263, 20);
		add(comboBox);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(61, 155, 263, 259);
		add(textPane);
		
		JButton btnInicioSesin = new JButton("Inicio Sesi\u00F3n");
		btnInicioSesin.setBounds(384, 11, 99, 23);
		add(btnInicioSesin);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.setBounds(384, 45, 99, 23);
		add(btnNewButton);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(384, 391, 89, 23);
		add(btnContinuar);
		
		JLabel lblNewLabel = new JLabel("L\u00CDNEAS");
		lblNewLabel.setFont(new Font("Mistral", Font.PLAIN, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 23, 314, 53);
		add(lblNewLabel);
		
		//¿¿¿Añadir temporizador en caso de inactividad???
	
	}
}
