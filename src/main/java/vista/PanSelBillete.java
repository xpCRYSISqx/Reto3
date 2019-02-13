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
import javax.swing.JComboBox;

public class PanSelBillete extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	public DefaultListModel<Object> modeloOrigen = new DefaultListModel<Object>();
	public DefaultListModel<Object> modeloDestino = new DefaultListModel<Object>();
	public JLabel lblIcono,lblOrigen,lblDestino;
	public JButton btnLogin,btnRegistro,btnContinuar,btnCancelar;
	public final ButtonGroup rbtnGroupBillete = new ButtonGroup();
	public JRadioButton rbtnIda,rbtnVuelta;
	public JList<Object> listaOrigen,listaDestino;
	public JComboBox<Object> boxLineas;
	
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
		
		boxLineas = new JComboBox<Object>();
		FormatoDiseno.formatoComboBox(boxLineas);
		boxLineas.setBounds(45, 200, 327, 30);
		add(boxLineas);

		lblOrigen = new JLabel("Selecccione origen");
		lblOrigen.setFont(new Font("Agency FB", Font.BOLD, 28));
		lblOrigen.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrigen.setBounds(45, 255, 327, 40);
		add(lblOrigen);
		
		listaOrigen = new JList<Object>();
		FormatoDiseno.formatoList(listaOrigen);
		listaOrigen.setBounds(45, 301, 320, 250);
		add(listaOrigen);
		
		lblDestino = new JLabel("Selecccione  destino");
		lblDestino.setFont(new Font("Agency FB", Font.BOLD, 28));
		lblDestino.setHorizontalAlignment(SwingConstants.LEFT);
		lblDestino.setBounds(400, 255, 327, 40);
		add(lblDestino);
		
		listaDestino = new JList<Object>();
		FormatoDiseno.formatoList(listaDestino);
		listaDestino.setBounds(400, 301, 320, 250);
		add(listaDestino);
		
		rbtnIda = new JRadioButton("Simple");
		FormatoDiseno.formatoRbtn(rbtnIda);
		rbtnIda.setBounds(800, 375, 180, 50);
		rbtnGroupBillete.add(rbtnIda);
		add(rbtnIda);
		
		rbtnVuelta = new JRadioButton("Ida / Vuelta");
		FormatoDiseno.formatoRbtn(rbtnVuelta);
		rbtnVuelta.setBounds(800, 425, 180, 50);
		rbtnGroupBillete.add(rbtnVuelta);
		add(rbtnVuelta);
		
	}
}
