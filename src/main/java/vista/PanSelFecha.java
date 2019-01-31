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
	
	public JButton btnContinuar;
	
	
	public PanSelFecha() {
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		JLabel lblSeleccinDeFecha = new JLabel("SELECCI\u00D3N DE FECHA");
		lblSeleccinDeFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccinDeFecha.setFont(new Font("Mistral", Font.PLAIN, 44));
		lblSeleccinDeFecha.setBounds(10, 11, 780, 62);
		add(lblSeleccinDeFecha);
		
		JButton btnInicioSesion = new JButton("Inicio de Sesi\u00F3n");
		btnInicioSesion.setBounds(887, 11, 130, 30);
		add(btnInicioSesion);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(887, 43, 130, 30);
		add(btnRegistrar);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(907, 686, 90, 30);
		add(btnContinuar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 686, 130, 30);
		add(btnCancelar);
		
		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblOrigen.setBounds(20, 111, 84, 23);
		add(lblOrigen);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblDestino.setBounds(20, 186, 66, 23);
		add(lblDestino);
		
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
		
		JCalendar fechaIda = new JCalendar();
		fechaIda.setBounds(30, 314, 184, 153);
		add(fechaIda);
		
		JLabel lblSeleccioneFecha = new JLabel("Seleccione fecha");
		lblSeleccioneFecha.setBounds(40, 289, 174, 14);
		add(lblSeleccioneFecha);
		
		// Panel interno con calendario solo para seleccionar fecha de vuelta en caso de haber seleccionado billete tipo: Ida/Vuelta en el paso anterior.
		// Billete simple = Este panel debera estar OCULTO
		// Billete ida/vuelta
		
		JPanel panFechaVuelta = new JPanel();
		panFechaVuelta.setBounds(528, 289, 455, 260);
		add(panFechaVuelta);
		panFechaVuelta.setLayout(null);
		
		JLabel lblSeleccioneVuelta = new JLabel("Seleccione vuelta");
		lblSeleccioneVuelta.setBounds(0, 0, 252, 14);
		panFechaVuelta.add(lblSeleccioneVuelta);
		
		JCalendar fechaVuelta = new JCalendar();
		fechaVuelta.setBounds(10, 25, 184, 153);
		panFechaVuelta.add(fechaVuelta);
	
	
	}
}
