package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class SelecFecha extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public SelecFecha() {
		setLayout(null);
		
		JLabel lblSeleccinDeFecha = new JLabel("SELECCI\u00D3N DE FECHA");
		lblSeleccinDeFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccinDeFecha.setFont(new Font("Mistral", Font.PLAIN, 44));
		lblSeleccinDeFecha.setBounds(10, 11, 361, 53);
		add(lblSeleccinDeFecha);
		
		JButton button = new JButton("Inicio de Sesi\u00F3n");
		button.setBounds(413, 11, 107, 23);
		add(button);
		
		JButton button_1 = new JButton("Registrar");
		button_1.setBounds(413, 45, 107, 23);
		add(button_1);
		
		JButton button_2 = new JButton("Continuar");
		button_2.setBounds(413, 522, 107, 23);
		add(button_2);
		
		JButton button_3 = new JButton("Cancelar");
		button_3.setBounds(10, 522, 89, 23);
		add(button_3);
		
		JLabel label = new JLabel("Origen");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label.setBounds(20, 111, 84, 23);
		add(label);
		
		JLabel label_1 = new JLabel("Destino");
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_1.setBounds(20, 186, 66, 23);
		add(label_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(30, 136, 248, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(30, 209, 248, 20);
		add(textField_1);

	}

}
