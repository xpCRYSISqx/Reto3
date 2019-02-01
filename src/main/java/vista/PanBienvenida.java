package vista;


import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.io.IOException;

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
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBackground(Color.WHITE);
		btnContinuar.setBounds(0, 0, 1024, 720);
		btnContinuar.setOpaque(false);
		btnContinuar.setContentAreaFilled(false);
		btnContinuar.setBorderPainted(false);
		add(btnContinuar);
		
		//¿¿¿Añadir temporizador en caso de inactividad???
	
	}
}
