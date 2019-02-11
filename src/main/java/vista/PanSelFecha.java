package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
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
	
	public JButton btnContinuar, btnLogin, btnRegistro, btnCancelar, btnAtras;
	public JLabel lblIcono, lblOrigen, lblDestino, lblSeleccioneFecha, lblSeleccioneVuelta;
	public JCalendar fechaIda, fechaVuelta;
	public JPanel panFechaVuelta;
	public JTextField txtOrigen, txtDestino;
	
	public PanSelFecha() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		lblIcono = new JLabel("SELECCI\u00D3N DE FECHA");
		FormatoDiseno.formatoIcono(lblIcono);
		add(lblIcono);
		
		btnLogin = new JButton("Inicio Sesi\u00F3n");
		FormatoDiseno.formatoBtnLogin(btnLogin);
		add(btnLogin);
		
		btnRegistro = new JButton("Registro");
		FormatoDiseno.formatoBtnRegistro(btnRegistro);
		add(btnRegistro);
		
		btnContinuar = new JButton("Continuar");
		FormatoDiseno.formatoBtnContinuar(btnContinuar);
		add(btnContinuar);
		
		btnCancelar = new JButton("Cancelar");
		FormatoDiseno.formatoBtnCancelar(btnCancelar);
		add(btnCancelar);
		
		lblOrigen = new JLabel("Origen");
		FormatoDiseno.formatoLbl(lblOrigen);
		lblOrigen.setBounds(30, 169, 100, 25);
		add(lblOrigen);
		
		lblDestino = new JLabel("Destino");
		FormatoDiseno.formatoLbl(lblDestino);
		lblDestino.setBounds(30, 205, 100, 25);
		add(lblDestino);
		
		txtOrigen = new JTextField();
		FormatoDiseno.formatoTxt(txtOrigen);
		txtOrigen.setEditable(false);
		txtOrigen.setBounds(140, 169, 250, 25);
		add(txtOrigen);
		
		txtDestino = new JTextField();
		FormatoDiseno.formatoTxt(txtDestino);
		txtDestino.setEditable(false);
		txtDestino.setBounds(140, 204, 250, 25);
		add(txtDestino);
		
		lblSeleccioneFecha = new JLabel("Seleccione fecha");
		FormatoDiseno.formatoLbl(lblSeleccioneFecha);
		lblSeleccioneFecha.setBounds(282, 290, 174, 14);
		add(lblSeleccioneFecha);
		
		fechaIda = new JCalendar();
		fechaIda.setBounds(282, 320, 200, 175);
		add(fechaIda);
		
		// Panel interno con calendario solo para seleccionar fecha de vuelta en caso de haber seleccionado billete tipo: Ida/Vuelta en el paso anterior.	
		panFechaVuelta = new JPanel();
		panFechaVuelta.setBackground(new Color(255, 255, 255));
		panFechaVuelta.setBounds(542, 289, 300, 260);
		panFechaVuelta.setLayout(null);
		add(panFechaVuelta);
		
		lblSeleccioneVuelta = new JLabel("Seleccione vuelta");
		FormatoDiseno.formatoLbl(lblSeleccioneVuelta);
		lblSeleccioneVuelta.setBounds(10, 0, 200, 14);
		panFechaVuelta.add(lblSeleccioneVuelta);
		
		fechaVuelta = new JCalendar();
		fechaVuelta.setBounds(10, 30, 200, 175);
		panFechaVuelta.add(fechaVuelta);
		
		btnAtras = new JButton("Atr\u00E1s");
		FormatoDiseno.formatoBtnAtras(btnAtras);
		add(btnAtras);
	
	
	}
}
