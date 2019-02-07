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
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	JPanel sel_fecha = new JPanel();
	
	public JButton btnContinuar, btnLogin, btnRegistrar, btnCancelar, btnAtras;
	public JLabel lblTitulo, lblOrigen, lblDestino, lblSeleccioneFecha, lblSeleccioneVuelta;
	public JCalendar fechaIda, fechaVuelta;
	public JPanel panFechaVuelta;
	public JTextField txtOrigen, txtDestino;
	
	public PanSelFecha() {
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		lblTitulo = new JLabel("SELECCI\u00D3N DE FECHA");
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setFont(new Font("Mistral", Font.PLAIN, 44));
		lblTitulo.setBounds(30, 35, 1004, 81);
		add(lblTitulo);
		
		btnLogin = new JButton("Inicio Sesi\u00F3n");
		btnLogin.setBounds(880, 35, 125, 25);
		add(btnLogin);
		
		btnRegistrar = new JButton("Registro");
		btnRegistrar.setBounds(880, 71, 125, 25);
		add(btnRegistrar);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(915, 650, 90, 25);
		add(btnContinuar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 650, 100, 25);
		add(btnCancelar);
		
		lblOrigen = new JLabel("Origen");
		lblOrigen.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblOrigen.setBounds(30, 169, 100, 25);
		add(lblOrigen);
		
		lblDestino = new JLabel("Destino");
		lblDestino.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblDestino.setBounds(30, 205, 100, 25);
		add(lblDestino);
		
		txtOrigen = new JTextField();
		txtOrigen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtOrigen.setEditable(false);
		txtOrigen.setBounds(140, 169, 250, 25);
		add(txtOrigen);
		txtOrigen.setColumns(10);
		
		txtDestino = new JTextField();
		txtDestino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDestino.setEditable(false);
		txtDestino.setColumns(10);
		txtDestino.setBounds(140, 204, 250, 25);
		add(txtDestino);
		
		lblSeleccioneFecha = new JLabel("Seleccione fecha");
		lblSeleccioneFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeleccioneFecha.setBounds(282, 290, 174, 14);
		add(lblSeleccioneFecha);
		
		fechaIda = new JCalendar();
		fechaIda.setBounds(282, 320, 200, 175);
		add(fechaIda);
		
		// Panel interno con calendario solo para seleccionar fecha de vuelta en caso de haber seleccionado billete tipo: Ida/Vuelta en el paso anterior.
		// Billete simple = Este panel debera estar OCULTO
		// Billete ida/vuelta
		
		panFechaVuelta = new JPanel();
		panFechaVuelta.setBounds(542, 289, 300, 260);
		add(panFechaVuelta);
		panFechaVuelta.setLayout(null);
		
		lblSeleccioneVuelta = new JLabel("Seleccione vuelta");
		lblSeleccioneVuelta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeleccioneVuelta.setBounds(10, 0, 200, 14);
		panFechaVuelta.add(lblSeleccioneVuelta);
		
		fechaVuelta = new JCalendar();
		fechaVuelta.setBounds(10, 30, 200, 175);
		panFechaVuelta.add(fechaVuelta);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(10, 614, 100, 25);
		add(btnAtras);
	
	
	}
}
