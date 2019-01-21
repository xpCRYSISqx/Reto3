package vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bienvenida extends JPanel {
	
	JPanel bienvenida = new JPanel();
	
	/**
	 * @wbp.parser.entryPoint
	 */
	
	public void CrearBienvenida() {
		bienvenida.setVisible(true);
		bienvenida.setLayout(null);
		
		bienvenida.setBounds(100, 100, 1280, 720);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(0, 0, 1280, 720);
		bienvenida.add(btnNewButton);
	}
	public JComponent PasarBienvenida() {
		return bienvenida;
	}

}
