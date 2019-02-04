package vista;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;

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
	public JLabel lblLineas;
	public DefaultListModel<String> modelo = new DefaultListModel<String>();
	public JList<String> listLineas,listParadas;
	
	public PanSelLinea() {
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		btnlogin = new JButton("Inicio Sesi\u00F3n");
		btnlogin.setBounds(895, 11, 119, 23);
		add(btnlogin);
		
		btnRegistro = new JButton("Registro");
		btnRegistro.setBounds(895, 34, 119, 23);
		add(btnRegistro);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(900, 634, 89, 23);
		add(btnContinuar);
		
		lblLineas = new JLabel("L\u00CDNEAS");
		lblLineas.setFont(new Font("Mistral", Font.PLAIN, 45));
		lblLineas.setHorizontalAlignment(SwingConstants.CENTER);
		lblLineas.setBounds(10, 23, 780, 53);
		add(lblLineas);
		
		listLineas = new JList<String>();
		listLineas.setBounds(226, 251, 200, 240);
		add(listLineas);
		
		listParadas = new JList<String>();
		listParadas.setBounds(436, 251, 200, 240);
		add(listParadas);
		
		//¿¿¿Añadir temporizador en caso de inactividad???
	
	}
}
