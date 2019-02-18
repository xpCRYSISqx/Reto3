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

	private static final long serialVersionUID = 1L;
	
	public DefaultListModel<Object> modeloOrigen = new DefaultListModel<Object>();
	public DefaultListModel<Object> modeloDestino = new DefaultListModel<Object>();
	public JLabel lblIcono,lblLinea, lblOrigen,lblDestino;
	public JButton btnLogin,btnRegistro,btnContinuar,btnCancelar;
	public final ButtonGroup rbtnGroupBillete = new ButtonGroup();
	public JRadioButton rbtnIda,rbtnVuelta;
	public JList<Object> listaOrigen,listaDestino;
	public JComboBox<Object> boxLineas;
	
	public PanSelBillete() {
		
		// configuracion del panel
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		// logo
		lblIcono = new JLabel("");
		FormatoDiseno.formatoIcono(lblIcono);
		add(lblIcono);
		
		// label seleccion linea
		lblLinea = new JLabel("Selecccione linea:");
		lblLinea.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblLinea.setHorizontalAlignment(SwingConstants.LEFT);
		lblLinea.setBounds(45, 200, 300, 40);
		add(lblLinea);
		
		// seleccion de linea
		boxLineas = new JComboBox<Object>();
		FormatoDiseno.formatoComboBox(boxLineas);
		boxLineas.setBounds(45, 245, 327, 30);
		add(boxLineas);
		
		// label seleccion parada origen
		lblOrigen = new JLabel("Selecccione origen:");
		lblOrigen.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblOrigen.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrigen.setBounds(45, 295, 300, 40);
		add(lblOrigen);
		
		// seleccion parada origen
		listaOrigen = new JList<Object>();
		FormatoDiseno.formatoList(listaOrigen);
		listaOrigen.setBounds(45, 340, 300, 230);
		add(listaOrigen);
		
		// label seleccion parada destino
		lblDestino = new JLabel("Selecccione destino:");
		lblDestino.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblDestino.setHorizontalAlignment(SwingConstants.LEFT);
		lblDestino.setBounds(370, 295, 300, 40);
		add(lblDestino);
		
		// seleccion parada destino
		listaDestino = new JList<Object>();
		FormatoDiseno.formatoList(listaDestino);
		listaDestino.setBounds(370, 340, 300, 230);
		add(listaDestino);
		
		// label seleccion parada destino
		lblDestino = new JLabel("Tipo de billete:");
		lblDestino.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblDestino.setHorizontalAlignment(SwingConstants.LEFT);
		lblDestino.setBounds(720, 295, 300, 40);
		add(lblDestino);
		
		// seleccion de billete simple
		rbtnIda = new JRadioButton("Simple");
		FormatoDiseno.formatoRbtn(rbtnIda);
		rbtnIda.setBounds(720, 340, 180, 50);
		rbtnIda.setSelected(true);
		rbtnGroupBillete.add(rbtnIda);
		add(rbtnIda);
		
		// seleccion de billete ida y vuelta
		rbtnVuelta = new JRadioButton("Ida / Vuelta");
		FormatoDiseno.formatoRbtn(rbtnVuelta);
		rbtnVuelta.setBounds(720, 390, 180, 50);
		rbtnGroupBillete.add(rbtnVuelta);
		add(rbtnVuelta);
		
		/*
		 * Botones
		 */
		
		btnLogin = new JButton("Inicio Sesi\u00F3n");
		FormatoDiseno.formatoBtnLogin(btnLogin);
		add(btnLogin);
		
		btnRegistro = new JButton("Registro");
		FormatoDiseno.formatoBtnRegistro(btnRegistro);
		add(btnRegistro);
		
		btnCancelar = new JButton("Cancelar");
		FormatoDiseno.formatoBtnCancelar(btnCancelar);
		add(btnCancelar);
		
		btnContinuar = new JButton("Continuar");
		FormatoDiseno.formatoBtnContinuar(btnContinuar);
		add(btnContinuar);
		
	}
}
