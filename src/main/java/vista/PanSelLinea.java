package vista;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.Rectangle;
import java.awt.Point;
import javax.swing.ImageIcon;

public class PanSelLinea extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	JPanel sel_linea = new JPanel();
	
	public JButton btnlogin,btnContinuar,btnRegistro, btnCancelar;
	public JLabel lblTitulo;
	public DefaultListModel<String> modeloLineas = new DefaultListModel<String>();
	public DefaultListModel<String> modeloParadas = new DefaultListModel<String>();
	public JList<String> listLineas,listParadas;
	
	public PanSelLinea() {
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
		
		btnlogin = new JButton("Inicio Sesi\u00F3n");
		btnlogin.setBorder(null);
		btnlogin.setForeground(new Color(255, 255, 255));
		btnlogin.setBackground(new Color(204, 0, 0));
		btnlogin.setBounds(821, 35, 125, 25);
		add(btnlogin);
		
		btnRegistro = new JButton("Registro");
		btnRegistro.setBorder(null);
		btnRegistro.setForeground(new Color(255, 255, 255));
		btnRegistro.setBackground(new Color(204, 0, 0));
		btnRegistro.setBounds(821, 70, 125, 25);
		add(btnRegistro);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBorderPainted(false);
		btnContinuar.setBorder(null);
		btnContinuar.setSelectedIcon(null);
		btnContinuar.setForeground(new Color(255, 255, 255));
		btnContinuar.setBackground(new Color(204, 0, 0));
		btnContinuar.setBounds(846, 610, 100, 25);
		add(btnContinuar);
		
		listLineas = new JList<String>();
		listLineas.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		listLineas.setBackground(new Color(255, 255, 255));
		listLineas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listLineas.setBounds(53, 251, 200, 240);
		add(listLineas);
		
		listParadas = new JList<String>();
		listParadas.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		listParadas.setBackground(new Color(255, 255, 255));
		listParadas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listParadas.setEnabled(false);
		listParadas.setBounds(263, 251, 250, 240);
		add(listParadas);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(new Color(204, 0, 0));
		btnCancelar.setBounds(53, 610, 100, 25);
		add(btnCancelar);
		
		JLabel lblLnea = new JLabel("L\u00EDneas");
		lblLnea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLnea.setBounds(53, 220, 200, 20);
		add(lblLnea);
		
		JLabel lblParadas = new JLabel("Lista de paradas");
		lblParadas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblParadas.setBounds(263, 220, 250, 20);
		add(lblParadas);
	
		//¿¿¿Añadir temporizador en caso de inactividad???
	
	}
}
