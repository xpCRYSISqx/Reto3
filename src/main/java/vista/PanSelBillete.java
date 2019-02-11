package vista;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JRadioButton;

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
	public final ButtonGroup rbtnGroupBillete = new ButtonGroup();
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
		lblOrigen.setFont(new Font("Agency FB", Font.BOLD, 28));
		lblOrigen.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrigen.setBounds(53, 200, 327, 40);
		add(lblOrigen);
		
		listaOrigen = new JList<String>();
		FormatoDiseno.formatoList(listaOrigen);
		listaOrigen.setBounds(53, 251, 327, 250);
		add(listaOrigen);
		
		lblDestino = new JLabel("Selecccione  destino");
		lblDestino.setFont(new Font("Agency FB", Font.BOLD, 28));
		lblDestino.setHorizontalAlignment(SwingConstants.LEFT);
		lblDestino.setBounds(400, 200, 327, 40);
		add(lblDestino);
		
		listaDestino = new JList<String>();
		FormatoDiseno.formatoList(listaDestino);
		listaDestino.setBounds(400, 251, 327, 250);
		add(listaDestino);
		
		btnAtras = new JButton("Atr\u00E1s");
		FormatoDiseno.formatoBtnAtras(btnAtras);
		add(btnAtras);
		
		rbtnIda = new JRadioButton("Simple");
		FormatoDiseno.formatoRbtn(rbtnIda);
		rbtnIda.setBounds(760, 251, 180, 50);
		rbtnGroupBillete.add(rbtnIda);
		add(rbtnIda);
		
		rbtnVuelta = new JRadioButton("Ida / Vuelta");
		FormatoDiseno.formatoRbtn(rbtnVuelta);
		rbtnVuelta.setBounds(760, 304, 180, 50);
		rbtnGroupBillete.add(rbtnVuelta);
		add(rbtnVuelta);

	}
}
