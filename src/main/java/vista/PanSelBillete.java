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
	
	public JLabel lblTitulo,lblOrigen,lblDestino;
	public JButton btnLogin,btnRegistro,btnContinuar,btnAtras,btnCancelar;
	public JRadioButton rbtnIda,rbtnVuelta;
	public JList listaOrigen,listaDestino;
	
	public PanSelBillete() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon(PanSelLinea.class.getResource("/img/logo-termibus.png")));
		lblTitulo.setOpaque(true);
		lblTitulo.setBorder(null);
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setBackground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 30));
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setBounds(53, 35, 306, 112);
		add(lblTitulo);
		
		btnLogin = new JButton("Inicio Sesi\u00F3n");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(204, 0, 0));
		btnLogin.setBounds(821, 35, 125, 25);
		btnLogin.setBorder(null);
		add(btnLogin);
		
		btnRegistro = new JButton("Registro");
		btnRegistro.setBackground(new Color(204, 0, 0));
		btnRegistro.setForeground(new Color(255, 255, 255));
		btnRegistro.setBounds(821, 70, 125, 25);
		btnRegistro.setBorder(null);
		add(btnRegistro);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBackground(new Color(204, 0, 0));
		btnContinuar.setForeground(new Color(255, 255, 255));
		btnContinuar.setBounds(846, 610, 100, 25);
		btnContinuar.setBorder(null);
		add(btnContinuar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(204, 0, 0));
		btnCancelar.setBounds(53, 610, 100, 25);
		btnCancelar.setBorder(null);
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
		listaOrigen.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		listaOrigen.setBackground(new Color(255, 255, 255));
		listaOrigen.setBounds(53, 251, 327, 250);
		add(listaOrigen);
		
		listaDestino = new JList<String>();
		listaDestino.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		listaDestino.setBackground(new Color(255, 255, 255));
		listaDestino.setBounds(400, 251, 327, 250);
		add(listaDestino);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setForeground(new Color(255, 255, 255));
		btnAtras.setBackground(new Color(204, 0, 0));
		btnAtras.setBounds(53, 574, 100, 25);
		btnAtras.setBorder(null);
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
