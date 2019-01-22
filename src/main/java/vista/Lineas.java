package vista;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

public class Lineas extends JPanel {

	JPanel lineas = new JPanel();
	/**
	 * @wbp.parser.entryPoint
	 */
	public void CrearLineas() {
		lineas.setVisible(false);
		lineas.setLayout(null);
		lineas.setBounds(0, 0, 800, 300);
	}
	public JComponent PasarLineas() {
		return lineas;
	}
}