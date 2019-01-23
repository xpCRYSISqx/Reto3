package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class DetallesCompra extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public DetallesCompra() {
		setLayout(null);
		
		JButton button = new JButton("Atr\u00E1s");
		button.setBounds(10, 449, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setBounds(10, 473, 89, 23);
		add(button_1);
		
		JButton button_2 = new JButton("Continuar");
		button_2.setBounds(514, 473, 107, 23);
		add(button_2);
		
		JButton button_3 = new JButton("Inicio de Sesi\u00F3n");
		button_3.setBounds(514, 11, 107, 23);
		add(button_3);
		
		JButton button_4 = new JButton("Registrar");
		button_4.setBounds(514, 45, 107, 23);
		add(button_4);
		
		JLabel lblDetallesDe = new JLabel("DETALLES DE BILLETE");
		lblDetallesDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetallesDe.setFont(new Font("Mistral", Font.PLAIN, 44));
		lblDetallesDe.setBounds(10, 11, 462, 53);
		add(lblDetallesDe);
		
		JLabel label = new JLabel("Origen");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label.setBounds(30, 143, 84, 23);
		add(label);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(40, 168, 218, 20);
		add(textField);
		
		JLabel label_1 = new JLabel("Destino");
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_1.setBounds(30, 199, 66, 23);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(40, 222, 218, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(20, 111, 248, 20);
		add(textField_2);
		
		JLabel lblLnea = new JLabel("L\u00CDNEA");
		lblLnea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblLnea.setBounds(10, 86, 84, 23);
		add(lblLnea);

	}
}
