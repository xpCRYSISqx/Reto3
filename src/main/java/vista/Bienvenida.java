package vista;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Gestion.GestionProductos;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.SystemColor;

public class Bienvenida extends JPanel {
	
	JPanel bienvenida = new JPanel();
	public JButton btnCont;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	
	public void CrearBienvenida() {
		bienvenida.setVisible(true);
		bienvenida.setLayout(null);
		
		bienvenida.setBounds(0, 0, 1280, 720);
		
		btnCont = new JButton("");
		btnCont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCont.setOpaque(false);
		btnCont.setContentAreaFilled(false);
		btnCont.setBorderPainted(false);
		btnCont.setBackground(SystemColor.window);
		btnCont.setBounds(0, 0, 1280, 720);
		bienvenida.add(btnCont);
	}
	public JComponent PasarBienvenida() {
		return bienvenida;
	}
}

////Botones pantalla 1
//JButton btnSiguiente = new JButton("");
//btnSiguiente.setFont(new Font("Arial Black", Font.PLAIN, 15));
//btnSiguiente.addActionListener(new ActionListener() {
//	public void actionPerformed(ActionEvent e) {
//		panelSaludo.setVisible(false);
//		panelProductos.setVisible(true);
//		GestionProductos.ListaProductos(listaProductos);
//	}
//});
//btnSiguiente.setBounds(new Rectangle(0, 0, 1190, 760));
//btnSiguiente.setOpaque(false);
//btnSiguiente.setContentAreaFilled(false);
//btnSiguiente.setBorderPainted(false);
//panelSaludo.add(btnSiguiente);
//
//JLabel lblSaludo = new JLabel("Ongi etorri");
//lblSaludo.setFont(new Font("Footlight MT Light", Font.BOLD, 45));
//lblSaludo.setBounds(106, 110, 291, 101);
//panelSaludo.add(lblSaludo);