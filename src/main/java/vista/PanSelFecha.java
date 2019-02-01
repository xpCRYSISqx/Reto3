package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PanSelFecha extends JPanel {
	
	/**
	 * Create the panel.
	 */
	
	JPanel sel_fecha = new JPanel();
	
	public JButton btnContinuar, btnLogin, btnRegistrar, btnCancelar;
	public JLabel lblTitulo, lblOrigen, lblDestino, lblSeleccioneFecha, lblSeleccioneVuelta;
	public JCalendar fechaIda, fechaVuelta;
	public JPanel panFechaVuelta;
	public JTextField txtOrigen, txtDestino;
	
	public PanSelFecha() {
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		lblTitulo = new JLabel("SELECCI\u00D3N DE FECHA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Mistral", Font.PLAIN, 44));
		lblTitulo.setBounds(10, 11, 780, 62);
		add(lblTitulo);
		
		btnLogin = new JButton("Inicio de Sesi\u00F3n");
		btnLogin.setBounds(887, 11, 130, 30);
		add(btnLogin);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(887, 43, 130, 30);
		add(btnRegistrar);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(907, 586, 90, 30);
		add(btnContinuar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 686, 130, 30);
		add(btnCancelar);
		
		lblOrigen = new JLabel("Origen");
		lblOrigen.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblOrigen.setBounds(20, 111, 84, 23);
		add(lblOrigen);
		
		lblDestino = new JLabel("Destino");
		lblDestino.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblDestino.setBounds(20, 186, 66, 23);
		add(lblDestino);
		
		txtOrigen = new JTextField();
		txtOrigen.setEditable(false);
		txtOrigen.setBounds(30, 136, 248, 20);
		add(txtOrigen);
		txtOrigen.setColumns(10);
		
		txtDestino = new JTextField();
		txtDestino.setEditable(false);
		txtDestino.setColumns(10);
		txtDestino.setBounds(30, 209, 248, 20);
		add(txtDestino);
		
		fechaIda = new JCalendar();
		fechaIda.setBounds(30, 314, 184, 153);
		add(fechaIda);
		
		lblSeleccioneFecha = new JLabel("Seleccione fecha");
		lblSeleccioneFecha.setBounds(40, 289, 174, 14);
		add(lblSeleccioneFecha);
		
		// Panel interno con calendario solo para seleccionar fecha de vuelta en caso de haber seleccionado billete tipo: Ida/Vuelta en el paso anterior.
		// Billete simple = Este panel debera estar OCULTO
		// Billete ida/vuelta
		
		panFechaVuelta = new JPanel();
		panFechaVuelta.setBounds(528, 289, 455, 260);
		add(panFechaVuelta);
		panFechaVuelta.setLayout(null);
		
		lblSeleccioneVuelta = new JLabel("Seleccione vuelta");
		lblSeleccioneVuelta.setBounds(0, 0, 252, 14);
		panFechaVuelta.add(lblSeleccioneVuelta);
		
		fechaVuelta = new JCalendar();
		fechaVuelta.setBounds(10, 25, 184, 153);
		panFechaVuelta.add(fechaVuelta);
	
	
	}
}
