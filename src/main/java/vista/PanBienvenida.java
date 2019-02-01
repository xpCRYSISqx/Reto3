package vista;


import javax.swing.JPanel;
import javax.swing.JButton;

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
	
	public PanBienvenida() {
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(0, 0, 1024, 720);
		add(btnContinuar);
		
		//¿¿¿Añadir temporizador en caso de inactividad???
	
	}
}
