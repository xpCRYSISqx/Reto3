package vista;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class PanSelBillete extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	JPanel sel_billete = new JPanel();
	
	public DefaultListModel<String> modeloOrigen = new DefaultListModel<String>();
	public DefaultListModel<String> modeloDestino = new DefaultListModel<String>();
	
	public JLabel lblIcono,lblOrigen,lblDestino;
	public JButton btnLogin,btnRegistro,btnContinuar,btnAtras,btnCancelar;
	public JRadioButton rbtnIda,rbtnVuelta;
	public JList<String> listaOrigen,listaDestino;
	
	public PanSelBillete() {
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
		
		btnCancelar = new JButton("Cancelar");
		FormatoDiseno.formatoBtnCancelar(btnCancelar);
		add(btnCancelar);
		
		lblOrigen = new JLabel("Selecccione origen");
		lblOrigen.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrigen.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOrigen.setBounds(53, 200, 327, 40);
		add(lblOrigen);
		
		lblDestino = new JLabel("Selecccione  destino");
		lblDestino.setHorizontalAlignment(SwingConstants.LEFT);
		lblDestino.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDestino.setBounds(400, 200, 327, 40);
		add(lblDestino);
		
		listaOrigen = new JList<String>();
		FormatoDiseno.formatoList(listaOrigen);
		listaOrigen.setBounds(53, 251, 327, 250);
		add(listaOrigen);
		
		listaDestino = new JList<String>();
		FormatoDiseno.formatoList(listaDestino);
		listaDestino.setBounds(400, 251, 327, 250);
		add(listaDestino);
		
		btnAtras = new JButton("Atr\u00E1s");
		FormatoDiseno.formatoBtnAtras(btnAtras);
		add(btnAtras);
		
		rbtnIda = new JRadioButton("Simple");
		rbtnIda.setBackground(new Color(255, 255, 255));
		rbtnIda.setHorizontalAlignment(SwingConstants.LEFT);
		rbtnIda.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rbtnIda.setBounds(760, 251, 180, 50);
		add(rbtnIda);
		
		rbtnVuelta = new JRadioButton("Ida / Vuelta");
		rbtnVuelta.setBackground(new Color(255, 255, 255));
		rbtnVuelta.setHorizontalAlignment(SwingConstants.LEFT);
		rbtnVuelta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rbtnVuelta.setBounds(760, 304, 180, 50);
		add(rbtnVuelta);

	}
}
