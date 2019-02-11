package vista;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
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
	
	public JButton btnLogin,btnContinuar,btnRegistro, btnCancelar;
	public JLabel lblIcono,lblLineas,lblParadas;
	public DefaultListModel<String> modeloLineas = new DefaultListModel<String>();
	public DefaultListModel<String> modeloParadas = new DefaultListModel<String>();
	public JList<String> listLineas,listParadas;
	
	public PanSelLinea() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		lblIcono = new JLabel("");
		FormatoDiseno.formatoIcono(lblIcono);
		add(lblIcono);
		
		btnLogin = new JButton("Inicio Sesi\u00F3n");
		FormatoDiseno.formatoBtnLogin(btnLogin);
		add(btnLogin);
		
		btnRegistro = new JButton("Registro");
		FormatoDiseno.formatoBtnRegistro(btnRegistro);
		add(btnRegistro);
		
		btnContinuar = new JButton("Continuar");
		FormatoDiseno.formatoBtnContinuar(btnContinuar);
		add(btnContinuar);
		
		lblLineas = new JLabel("L\u00EDneas");
		lblLineas.setFont(new Font("Agency FB", Font.BOLD, 28));
		lblLineas.setBounds(53, 212, 200, 40);
		add(lblLineas);
		
		listLineas = new JList<String>();
		FormatoDiseno.formatoList(listLineas);
//		listLineas.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
//		listLineas.setBackground(new Color(255, 255, 255));
//		listLineas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listLineas.setBounds(53, 251, 200, 240);
		add(listLineas);
		
		lblParadas = new JLabel("Lista de paradas");
		lblParadas.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblParadas.setBounds(263, 212, 250, 40);
		add(lblParadas);
	
		listParadas = new JList<String>();
		FormatoDiseno.formatoList(listParadas);
//		listParadas.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
//		listParadas.setBackground(new Color(255, 255, 255));
//		listParadas.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		listParadas.setEnabled(false);
		listParadas.setBounds(263, 251, 250, 240);
		add(listParadas);
		
		btnCancelar = new JButton("Cancelar");
		FormatoDiseno.formatoBtnCancelar(btnCancelar);
		add(btnCancelar);
		
		//¿¿¿Añadir temporizador en caso de inactividad???
	
	}
}
