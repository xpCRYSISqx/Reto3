package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanDespedida extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public JLabel lblIcono;
	public JLabel lblDespedida;
	
	public PanDespedida() {
		
		// configuracion del panel
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		// logo
		lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(PanBienvenida.class.getResource("/img/logo-termibus.png")));
		lblIcono.setBounds(368, 132, 301, 183);
		add(lblIcono);
		
		// mensaje de despedida
		lblDespedida = new JLabel("Que tenga un buen viaje");
		lblDespedida.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblDespedida.setBounds(380, 380, 300, 50);
		add(lblDespedida);

	}

}
