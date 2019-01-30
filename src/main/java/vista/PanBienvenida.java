package vista;

import javax.swing.JPanel;
import javax.swing.JButton;

public class PanBienvenida extends JPanel {

	/**
	 * Create the panel.
	 */
	
	JPanel sel_linea = new JPanel();
	public JButton btnCont;
	
	public PanBienvenida() {
		setLayout(null);
		setBounds(0, 0, 800, 600);
		
		btnCont = new JButton("Continuar");
		btnCont.setBounds(0, 0, 800, 600);
		add(btnCont);
		
		//¿¿¿Añadir temporizador en caso de inactividad???
	
	}
}
