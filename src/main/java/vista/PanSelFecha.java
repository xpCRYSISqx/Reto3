package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanSelFecha extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public JButton btnContinuar, btnLogin, btnRegistro, btnCancelar, btnAtras;
	public JLabel lblIcono, lblOrigen, lblDestino, lblSeleccioneFecha, lblSeleccioneVuelta, lblBilleteIda, lblPrecioBilleteIda, lblBilleteVuelta, lblPrecioBilleteVuelta, lblTotal, lblPrecioTotal;
	public JCalendar fechaIda, fechaVuelta;
	public JPanel panFechaVuelta, panelTotales;
	public JTextField txtOrigen, txtDestino;
	
	public PanSelFecha() {
		
		// configuracion del panel
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		// logo
		lblIcono = new JLabel("");
		FormatoDiseno.formatoIcono(lblIcono);
		add(lblIcono);
		
		lblOrigen = new JLabel("Origen");
		FormatoDiseno.formatoLbl(lblOrigen);
		lblOrigen.setBounds(45, 210, 100, 25);
		add(lblOrigen);
		
		txtOrigen = new JTextField();
		FormatoDiseno.formatoTxt(txtOrigen);
		txtOrigen.setEditable(false);
		txtOrigen.setBounds(130, 215, 250, 25);
		add(txtOrigen);
		
		lblDestino = new JLabel("Destino");
		FormatoDiseno.formatoLbl(lblDestino);
		lblDestino.setBounds(45, 245, 100, 25);
		add(lblDestino);
		
		txtDestino = new JTextField();
		FormatoDiseno.formatoTxt(txtDestino);
		txtDestino.setEditable(false);
		txtDestino.setBounds(130, 245, 250, 25);
		add(txtDestino);
		
		// label seleccion fecha de ida
		lblSeleccioneFecha = new JLabel("Seleccione fecha de ida");
		FormatoDiseno.formatoLbl(lblSeleccioneFecha);
		lblSeleccioneFecha.setBounds(45, 320, 174, 25);
		add(lblSeleccioneFecha);
		
		// seleccion fecha de ida
		fechaIda = new JCalendar();
		FormatoDiseno.formatoCalendario(fechaIda);
		fechaIda.setBounds(45, 350, 200, 175);
		add(fechaIda);
		
		// Panel interno con calendario solo para seleccionar fecha de vuelta en caso de haber seleccionado billete tipo: Ida/Vuelta en el paso anterior.	
		panFechaVuelta = new JPanel();
		panFechaVuelta.setBackground(new Color(255, 255, 255));
		panFechaVuelta.setBounds(305, 320, 250, 260);
		panFechaVuelta.setLayout(null);
		add(panFechaVuelta);
		panFechaVuelta.setVisible(false);
		
		// label seleccion fecha de vuelta
		lblSeleccioneVuelta = new JLabel("Seleccione fecha de vuelta");
		FormatoDiseno.formatoLbl(lblSeleccioneVuelta);
		lblSeleccioneVuelta.setBounds(10, 0, 200, 25);
		panFechaVuelta.add(lblSeleccioneVuelta);
		
		// seleccion fecha de vuelta
		fechaVuelta = new JCalendar();
		FormatoDiseno.formatoCalendario(fechaVuelta);
		fechaVuelta.setBounds(10, 30, 200, 175);
		panFechaVuelta.add(fechaVuelta);
		
		/*
		 * Botones
		 */
		
		btnLogin = new JButton("Inicio Sesi\u00F3n");
		FormatoDiseno.formatoBtnLogin(btnLogin);
		add(btnLogin);
		
		btnRegistro = new JButton("Registro");
		FormatoDiseno.formatoBtnRegistro(btnRegistro);
		add(btnRegistro);
		
		btnAtras = new JButton("Atr\u00E1s");
		FormatoDiseno.formatoBtnAtras(btnAtras);
		add(btnAtras);
		
		btnCancelar = new JButton("Cancelar");
		FormatoDiseno.formatoBtnCancelar(btnCancelar);
		add(btnCancelar);
		
		btnContinuar = new JButton("Continuar");
		FormatoDiseno.formatoBtnContinuar(btnContinuar);
		add(btnContinuar);
	
	
	}
}
