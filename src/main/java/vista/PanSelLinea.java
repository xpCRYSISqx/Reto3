package vista;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;

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
	public JLabel lblTitulo;
	public DefaultListModel<String> modeloLineas = new DefaultListModel<String>();
	public DefaultListModel<String> modeloParadas = new DefaultListModel<String>();
	public JList<String> listLineas,listParadas;
	
	public PanSelLinea() {
		setBackground(new Color(255, 192, 203));
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		lblTitulo = new JLabel("SELECCI\u00D3N DE L\u00CDNEAS");
		lblTitulo.setFont(new Font("Mistral", Font.PLAIN, 45));
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setBounds(30, 35, 1004, 81);
		add(lblTitulo);
		
		btnlogin = new JButton("Inicio Sesi\u00F3n");
		btnlogin.setBounds(880, 35, 125, 25);
		add(btnlogin);
		
		btnRegistro = new JButton("Registro");
		btnRegistro.setBounds(880, 71, 125, 25);
		add(btnRegistro);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(915, 650, 90, 25);
		add(btnContinuar);
		
		listLineas = new JList<String>();
		listLineas.setBackground(new Color(220, 220, 220));
		listLineas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listLineas.setBounds(302, 251, 200, 240);
		add(listLineas);
		
		listParadas = new JList<String>();
		listParadas.setBackground(new Color(220, 220, 220));
		listParadas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listParadas.setEnabled(false);
		listParadas.setBounds(522, 251, 250, 240);
		add(listParadas);
		
		JLabel lblLnea = new JLabel("L\u00EDneas");
		lblLnea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLnea.setBounds(302, 220, 200, 20);
		add(lblLnea);
		
		JLabel lblParadas = new JLabel("Lista de paradas");
		lblParadas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblParadas.setBounds(522, 220, 250, 20);
		add(lblParadas);
	
		//���A�adir temporizador en caso de inactividad???
	
	}
}
