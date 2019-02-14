package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class PanBienvenida extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JButton btnContinuar;
	public JLabel lblIcono;
	
	public PanBienvenida() throws IOException {
		
		// configuracion del panel
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		// logo
		lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(PanBienvenida.class.getResource("/img/logo-termibus.png")));
		lblIcono.setBounds(368, 132, 301, 183);
		add(lblIcono);
		
		// boton para comenzar
		btnContinuar = new JButton("Toca la pantalla para comenzar");
		btnContinuar.setSelectedIcon(null);
		btnContinuar.setContentAreaFilled(false);
		btnContinuar.setBorder(null);
		btnContinuar.setForeground(new Color(255, 51, 51));
		btnContinuar.setFont(new Font("Agency FB", Font.PLAIN, 24));
		btnContinuar.setBackground(Color.WHITE);
		btnContinuar.setBounds(0, 0, 1024, 720);
		btnContinuar.setOpaque(false);
		btnContinuar.setBorderPainted(false);
		add(btnContinuar);
	
	}
}
