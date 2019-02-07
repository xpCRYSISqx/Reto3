package vista;


import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class PanBienvenida extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	
	JPanel sel_linea = new JPanel();
	public JButton btnContinuar;
	
	public PanBienvenida() throws IOException {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		btnContinuar = new JButton("Toca la pantalla para comenzar");
		btnContinuar.setSelectedIcon(null);
		btnContinuar.setContentAreaFilled(false);
		btnContinuar.setBorder(null);
		btnContinuar.setForeground(new Color(255, 51, 51));
		btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnContinuar.setBackground(Color.WHITE);
		btnContinuar.setBounds(0, 0, 1024, 720);
		btnContinuar.setOpaque(false);
		btnContinuar.setBorderPainted(false);
		add(btnContinuar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PanBienvenida.class.getResource("/img/logo-termibus.png")));
		lblNewLabel.setBounds(368, 132, 301, 183);
		add(lblNewLabel);
		
		//���A�adir temporizador en caso de inactividad???
	
	}
}
