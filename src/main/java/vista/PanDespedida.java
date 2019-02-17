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
		lblIcono.setIcon(new ImageIcon(PanBienvenida.class.getResource("/img/image.png")));
		lblIcono.setBounds(120, 130, 1024, 300);
		add(lblIcono);
		
		// mensaje de despedida
		lblDespedida = new JLabel("¡Que tenga un buen viaje!");
		lblDespedida.setFont(new Font("Agency FB", Font.BOLD, 36));
		lblDespedida.setBounds(380, 450, 300, 50);
		add(lblDespedida);

	}

}
