package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanDespedida extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	
	public JLabel lblIcono;
	public JLabel lblDespedida1,lblDespedida2;
	
	public PanDespedida() {

		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(PanBienvenida.class.getResource("/img/logo-termibus.png")));
		lblIcono.setBounds(368, 132, 301, 183);
		add(lblIcono);
		
		lblDespedida1 = new JLabel("¡Gracias por su compra!");
		lblDespedida1.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblDespedida1.setBounds(380, 380, 300, 50);
		add(lblDespedida1);
		
		lblDespedida2 = new JLabel("Que tenga un buen viaje");
		lblDespedida2.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblDespedida2.setBounds(380, 440, 300, 50);
		add(lblDespedida2);

	}

}
