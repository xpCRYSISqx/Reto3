package vista;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.SystemColor;

public class PanBienvenida extends JPanel {
	
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
		btnCont.setOpaque(false);
		btnCont.setContentAreaFilled(false);
		btnCont.setBorderPainted(false);
		btnCont.setBackground(SystemColor.window);
		btnCont.setBounds(-10, 0, 1280, 720);
		bienvenida.add(btnCont);
	}
	public JComponent PasarBienvenida() {
		return bienvenida;
	}
}