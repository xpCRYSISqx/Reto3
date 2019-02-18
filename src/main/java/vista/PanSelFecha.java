package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

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
		lblOrigen.setBounds(45, 195, 100, 25);
		add(lblOrigen);
		
		lblDestino = new JLabel("Destino");
		FormatoDiseno.formatoLbl(lblDestino);
		lblDestino.setBounds(45, 230, 100, 25);
		add(lblDestino);
		
		txtOrigen = new JTextField();
		FormatoDiseno.formatoTxt(txtOrigen);
		txtOrigen.setEditable(false);
		txtOrigen.setBounds(130, 195, 250, 25);
		add(txtOrigen);
		
		txtDestino = new JTextField();
		FormatoDiseno.formatoTxt(txtDestino);
		txtDestino.setEditable(false);
		txtDestino.setBounds(130, 230, 250, 25);
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
		
		// Panel donde se muestran los datos del pago al instante
		panelTotales = new JPanel();
		panelTotales.setBackground(Color.GRAY);
		panelTotales.setBounds(600, 195, 350, 170);
		add(panelTotales);
		panelTotales.setLayout(null);
		
		lblBilleteIda = new JLabel("Billete Ida");
		lblBilleteIda.setFont(new Font("Arial", Font.PLAIN, 20));
		lblBilleteIda.setBounds(20, 20, 150, 32);
		panelTotales.add(lblBilleteIda);
		
		lblPrecioBilleteIda = new JLabel("0 \u20AC");
		lblPrecioBilleteIda.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecioBilleteIda.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPrecioBilleteIda.setBounds(190, 20, 121, 32);
		panelTotales.add(lblPrecioBilleteIda);
		
		lblBilleteVuelta = new JLabel("Billete Vuelta");
		lblBilleteVuelta.setFont(new Font("Arial", Font.PLAIN, 20));
		lblBilleteVuelta.setBounds(20, 70, 150, 32);
		panelTotales.add(lblBilleteVuelta);
		
		lblPrecioBilleteVuelta = new JLabel("0 \u20AC");
		lblPrecioBilleteVuelta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecioBilleteVuelta.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPrecioBilleteVuelta.setBounds(190, 70, 121, 32);
		panelTotales.add(lblPrecioBilleteVuelta);
		
		lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTotal.setBounds(20, 120, 150, 32);
		panelTotales.add(lblTotal);
		
		lblPrecioTotal = new JLabel("0 \u20AC");
		lblPrecioTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecioTotal.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPrecioTotal.setBounds(190, 120, 121, 32);
		panelTotales.add(lblPrecioTotal);
		
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
