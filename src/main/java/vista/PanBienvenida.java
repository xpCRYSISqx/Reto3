package vista;


import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JButton;

public class PanBienvenida extends JPanel {

	/**
	 * Create the panel.
	 */
	
	JPanel sel_linea = new JPanel();
	public JButton btnContinuar;
	
	public PanBienvenida() {
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(0, 0, 1024, 720);
		add(btnContinuar);
		
		//���A�adir temporizador en caso de inactividad???
	
	}
}
