package vista;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;

public class PanSelLinea extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	JPanel sel_linea = new JPanel();
	
	public JButton btnlogin,btnContinuar,btnRegistro;
	public JComboBox boxLineas;
	public JTextPane textPaneParadas;
	public JLabel lblLineas;
	
	
	public PanSelLinea() {
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		boxLineas = new JComboBox();
		boxLineas.setModel(new DefaultComboBoxModel(new String[] {"L1: Termibus - Plentzia", "L2: Termibus - Muskiz", "L3: Termibus - Balmaseda", "L4: Termibus - Durango"}));
		boxLineas.setMaximumRowCount(4);
		boxLineas.setBounds(274, 111, 263, 20);
		add(boxLineas);
		
		textPaneParadas = new JTextPane();
		textPaneParadas.setBounds(274, 154, 263, 336);
		add(textPaneParadas);
		
		btnlogin = new JButton("Inicio Sesi\u00F3n");
		btnlogin.setBounds(895, 11, 119, 23);
		add(btnlogin);
		
		btnRegistro = new JButton("Registro");
		btnRegistro.setBounds(895, 34, 119, 23);
		add(btnRegistro);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(895, 586, 89, 23);
		add(btnContinuar);
		
		lblLineas = new JLabel("L\u00CDNEAS");
		lblLineas.setFont(new Font("Mistral", Font.PLAIN, 45));
		lblLineas.setHorizontalAlignment(SwingConstants.CENTER);
		lblLineas.setBounds(10, 23, 780, 53);
		add(lblLineas);
		
		//¿¿¿Añadir temporizador en caso de inactividad???
	
	}
}
