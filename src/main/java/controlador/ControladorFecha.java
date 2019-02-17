package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import modelo.Autobus;
import modelo.Billete;
import modelo.Modelo;
import vista.MainFrame;

public class ControladorFecha implements ActionListener, PropertyChangeListener {
	
	public MainFrame vista;
	public Modelo modelo;
	
	public ControladorFecha(MainFrame vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	// añadimos listeners a los botones del panel 'sel_fecha'
	public void addListeners() {
		vista.sel_fecha.btnAtras.addActionListener(this);
		vista.sel_fecha.btnCancelar.addActionListener(this);
		vista.sel_fecha.btnLogin.addActionListener(this);
		vista.sel_fecha.btnRegistro.addActionListener(this);
		vista.sel_fecha.btnContinuar.addActionListener(this);
		vista.sel_fecha.fechaIda.addPropertyChangeListener(this);
		vista.sel_fecha.fechaVuelta.addPropertyChangeListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand();
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones
		switch (botonPulsado) {
		
			case "Atrás":
				
				vista.sel_billete.setVisible(true);
				vista.sel_fecha.setVisible(false);
				break;
			
			case "Cancelar":
				
				//vista.bienvenida.setVisible(true);
				//vista.sel_fecha.setVisible(false);
				ControladorCancelar can = new ControladorCancelar(vista, modelo);
				can.reset();
				break;
				
			case "Inicio Sesión":
				
				vista.login.setVisible(true);
				vista.sel_fecha.setVisible(false);
				ControladorLogin.panelOrigen = vista.sel_fecha;
				break;
				
			case "Registro":
				
				vista.registro.setVisible(true);
				vista.sel_fecha.setVisible(false);
				ControladorRegistro.panelOrigen = vista.sel_fecha;
				break;
				
			case "Continuar":
				
				if(validarDatos()) {
				
					// mostramos los datos en la siguiente pantalla 'detalles_compra'
					actualizarFrame();
				
				}
				
				break;
		
		}
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {

		// guardamos el nombre del boton pulsado
		JCalendar botonPulsado = ((JCalendar) e.getSource());
		
		if (botonPulsado == vista.sel_fecha.fechaIda) {
			
			Date fechaIda = new Date(vista.sel_fecha.fechaIda.getDate().getTime());
			Autobus autobusDisponible = comprobarAutobusDisponible(fechaIda);
			
			if (autobusDisponible != null) {
				
				try {
					
					Date fechaLimite = new Date(new SimpleDateFormat("MM-dd-yyyy").parse("12-31-2020").getTime());
					vista.sel_fecha.fechaVuelta.setSelectableDateRange(fechaIda,fechaLimite);
					
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
			} else {
				JOptionPane.showMessageDialog(vista, "No hay plazas disponibles para la fecha elegida. Por favor, seleccione una fecha de ida diferente.", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
			
		} else {
			
			Date fechaVuelta = new Date(vista.sel_fecha.fechaVuelta.getDate().getTime());
			Autobus autobusDisponible = comprobarAutobusDisponible(fechaVuelta);
			
			if (autobusDisponible == null) {
				JOptionPane.showMessageDialog(vista, "No hay plazas disponibles para la fecha elegida. Por favor, seleccione una fecha de vuelta diferente.", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
			
		}		
		
	}
	
	public boolean validarDatos() {
		
		// comprobamos si hay plazas disponibles para la fecha de Ida
		Date fechaIda = new Date(vista.sel_fecha.fechaIda.getDate().getTime());
		Autobus autobusIda = comprobarAutobusDisponible(fechaIda);
		
		if (autobusIda != null) {
			modelo.autobus = autobusIda;
			modelo.billeteIda.setCodBus(autobusIda.getCodBus());;
			modelo.billeteIda.setFecha(fechaIda);
			modelo.billeteIda.setHora("11:00");
			modelo.billeteIda.setPrecio(calcularPrecioBillete(modelo.billeteIda));
		}  else {
			JOptionPane.showMessageDialog(vista, "No hay plazas disponibles para la fecha elegida. Por favor, seleccione una fecha de ida diferente.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		// comprobamos si existe billete de vuelta
		if (modelo.billeteVuelta != null) {
			
			// comprobamos si hay plazas disponibles para la fecha de vuelta
			Date fechaVuelta = new Date(vista.sel_fecha.fechaVuelta.getDate().getTime());
			Autobus autobusVuelta = comprobarAutobusDisponible(fechaVuelta);
			
			if (autobusVuelta != null) {
				modelo.autobus = autobusIda;
				modelo.billeteVuelta.setCodBus(autobusVuelta.getCodBus());
				modelo.billeteVuelta.setFecha(fechaVuelta);
				modelo.billeteVuelta.setHora("18:00");
				modelo.billeteVuelta.setPrecio(calcularPrecioBillete(modelo.billeteVuelta));
			}  else {
				JOptionPane.showMessageDialog(vista, "No hay plazas disponibles para la fecha elegida. Por favor, seleccione una fecha de vuelta diferente.", "Aviso", JOptionPane.WARNING_MESSAGE);
				return false;
			}
			
		}
		
		return true;
		
	}
	
	public void actualizarFrame() {
		
		// mostramos los datos del billete en la siguiente pantalla 'detalles_compra'
		DefaultTableModel tablaIda = (DefaultTableModel) vista.detalles_compra.detallesIda.getModel();
		mostrarBillete(modelo.billeteIda, tablaIda);
		
		// comprobamos si existe billete de vuelta, si existe mostramos los datos
		if (modelo.billeteVuelta != null) {
			
			DefaultTableModel tablaVuelta = (DefaultTableModel) vista.detalles_compra.detallesVuelta.getModel();
			mostrarBillete(modelo.billeteVuelta, tablaVuelta);
			
		} else {
			vista.detalles_compra.detallesVuelta.setVisible(false);
			vista.detalles_compra.scrollPaneVuelta.setVisible(false);
		}
		
		// muestra el siguiente panel 'detalles_compra'
		vista.detalles_compra.setVisible(true);
		vista.sel_fecha.setVisible(false);
		
	}
	
	public Autobus comprobarAutobusDisponible(Date fecha) {
		
		ArrayList<Autobus> autobuses = modelo.linea.getAutobuses();
		Autobus autobusDisponible = null;
		Boolean plazasDisponibles = false;

		for(int i = 0;i<autobuses.size();i++) {
			plazasDisponibles = modelo.consultas.comprobarPlazasBillete(autobuses.get(i).getCodBus(),fecha);
			if (plazasDisponibles) {
				autobusDisponible = autobuses.get(i);
				break;
			}
		}
		
		return autobusDisponible;
		
	}
	
	public void mostrarBillete(Billete billete, DefaultTableModel tabla) {
		
		Object[] datosBillete = new Object[7];
		tabla.setRowCount(0);
		datosBillete[0] = billete.getCodLinea() + ": " + modelo.linea.getNombre();
		datosBillete[1] = modelo.paradaOrigen.getNombre();
		datosBillete[2] = modelo.paradaDestino.getNombre();
		datosBillete[3] = billete.getCodBus();
		datosBillete[4] = billete.getFecha();
		datosBillete[5] = billete.getHora();
		datosBillete[6] = billete.getPrecio() + "€";
		
		tabla.addRow(datosBillete);
		
	}
	
	public float calcularPrecioBillete(Billete billete) {
		
		float lat1 = modelo.paradaOrigen.getLatitud();
		float lon1 = modelo.paradaOrigen.getLongitud();
		float lat2 = modelo.paradaDestino.getLatitud();
		float lon2 = modelo.paradaOrigen.getLongitud();
		Autobus autobus = modelo.autobus;
		
		return modelo.consultas.calcularPrecioBillete(lat1, lon1, lat2, lon2, autobus);

	}

}