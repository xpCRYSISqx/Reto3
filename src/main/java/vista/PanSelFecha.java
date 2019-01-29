package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JMonthChooser;

public class PanSelFecha extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	
	JPanel sel_fecha = new JPanel();
	
	
	public PanSelFecha() {
		setLayout(null);
		setBounds(0, 0, 800, 600);
		
		JLabel lblSeleccinDeFecha = new JLabel("SELECCI\u00D3N DE FECHA");
		lblSeleccinDeFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccinDeFecha.setFont(new Font("Mistral", Font.PLAIN, 44));
		lblSeleccinDeFecha.setBounds(10, 11, 780, 62);
		add(lblSeleccinDeFecha);
		
		JButton button = new JButton("Inicio de Sesi\u00F3n");
		button.setBounds(683, 11, 107, 23);
		add(button);
		
		JButton button_1 = new JButton("Registrar");
		button_1.setBounds(683, 34, 107, 23);
		add(button_1);
		
		JButton button_2 = new JButton("Continuar");
		button_2.setBounds(683, 566, 107, 23);
		add(button_2);
		
		JButton button_3 = new JButton("Cancelar");
		button_3.setBounds(10, 566, 89, 23);
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
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(30, 314, 184, 153);
		add(calendar);
		
		JLabel lblSeleccioneFecha = new JLabel("Seleccione fecha");
		lblSeleccioneFecha.setBounds(40, 289, 80, 14);
		add(lblSeleccioneFecha);
		
		// Panel interno con calendario solo para seleccionar fecha de vuelta en caso de haber seleccionado billete tipo: Ida/Vuelta en el paso anterior.
		// Billete simple = Este panel debera estar OCULTO
		// Billete ida/ve
		
		JPanel panel = new JPanel();
		panel.setBounds(429, 289, 262, 178);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione vuelta");
		lblNewLabel.setBounds(0, 0, 83, 14);
		panel.add(lblNewLabel);
		
		JCalendar calendar_1 = new JCalendar();
		calendar_1.setBounds(10, 25, 184, 153);
		panel.add(calendar_1);
	
	
	}
}
