package vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		btnNewButton.setBounds(794, 577, 89, 23);
		bienvenida.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Hola");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 87));
		lblNewLabel.setBounds(436, 113, 247, 337);
		bienvenida.add(lblNewLabel);
	}
	public JComponent PasarBienvenida() {
		return bienvenida;
	}

}
