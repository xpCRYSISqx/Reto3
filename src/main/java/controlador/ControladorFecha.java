package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import modelo.Autobus;
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
				
				vista.bienvenida.setVisible(true);
				vista.sel_fecha.setVisible(false);
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
				
				// muestra el siguiente panel 'detalles_compra'
				vista.detalles_compra.setVisible(true);
				vista.sel_fecha.setVisible(false);
				
				// guardamos la fecha seleccionada para el billete de Ida
				Date fechaIda = new Date(vista.sel_fecha.fechaIda.getDate().getTime());
				modelo.billeteIda.setFecha(fechaIda);
				
				// comprobamos si existe billete de vuelta, si existe guardamos la fecha seleccionada
				if (modelo.billeteVuelta != null) {
					Date fechaVuelta = new Date(vista.sel_fecha.fechaVuelta.getDate().getTime());
					modelo.billeteVuelta.setFecha(fechaVuelta);
				}
				
				// mostramos los datos del billete en la siguiente pantalla 'detalles_compra'
				Object[] datosBilleteIda = new Object[5];
				datosBilleteIda[0] = modelo.billeteIda.getCodLinea();
				datosBilleteIda[1] = modelo.billeteIda.getCodParadaInicio();
				datosBilleteIda[2] = modelo.billeteIda.getCodParadaFin();
				datosBilleteIda[3] = modelo.billeteIda.getFecha();
				datosBilleteIda[4] = modelo.billeteIda.getHora();
				
				DefaultTableModel detallesIda = (DefaultTableModel) vista.detalles_compra.detallesIda.getModel();
				detallesIda.addRow(datosBilleteIda);
				
				// comprobamos si existe billete de vuelta, si existe mostramos los datos en la siguiente pantalla 'detalles_compra'
				if (modelo.billeteVuelta != null) {
					
					Object[] datosBilleteVuelta = new Object[5];
					datosBilleteVuelta[0] = modelo.billeteVuelta.getCodLinea();
					datosBilleteVuelta[1] = modelo.billeteVuelta.getCodParadaInicio();
					datosBilleteVuelta[2] = modelo.billeteVuelta.getCodParadaFin();
					datosBilleteVuelta[3] = modelo.billeteVuelta.getFecha();
					datosBilleteVuelta[4] = modelo.billeteVuelta.getHora();
					
					DefaultTableModel detallesVuelta = (DefaultTableModel) vista.detalles_compra.detallesVuelta.getModel();
					detallesVuelta.addRow(datosBilleteVuelta);
					
				} else {
					vista.detalles_compra.detallesVuelta.setVisible(false);
					vista.detalles_compra.scrollPaneVuelta.setVisible(false);
				}
				
				break;
		
		}
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		
		ArrayList<Autobus> autobuses = modelo.linea.getAutobuses();
		Boolean plazasDisponibles = false;

		// guardamos el nombre del boton pulsado
		JCalendar botonPulsado = ((JCalendar) e.getSource());
		
		if (botonPulsado == vista.sel_fecha.fechaIda) {
			
			Date fechaIda = new Date(vista.sel_fecha.fechaIda.getDate().getTime());
			
			for(int i = 0;i<autobuses.size();i++) {
				plazasDisponibles = modelo.consultas.comprobarPlazasBillete(autobuses.get(i).getCodBus(),fechaIda);
				if (plazasDisponibles) {
					modelo.autobus = autobuses.get(i);
					break;
				}
			}
			
			if (!plazasDisponibles) {
				JOptionPane.showMessageDialog(vista, "No hay plazas disponibles para la fecha elegida. Por favor, seleccione una fecha de ida diferente.", "Aviso", JOptionPane.WARNING_MESSAGE);
			} else {
				
				DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
				Date fechaLimite;
				
				try {
					
					fechaLimite = new Date(df.parse("12-31-2020").getTime());
					vista.sel_fecha.fechaVuelta.setSelectableDateRange(fechaIda,fechaLimite);
					
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
			}
			
		} else {
			
			Date fechaVuelta = new Date(vista.sel_fecha.fechaVuelta.getDate().getTime());

			for(int i = 0;i<autobuses.size();i++) {
				plazasDisponibles = modelo.consultas.comprobarPlazasBillete(autobuses.get(i).getCodBus(),fechaVuelta);
				if (plazasDisponibles) {
					modelo.autobus = autobuses.get(i);
					break;
				}
			}
			
			if (!plazasDisponibles) {
				JOptionPane.showMessageDialog(vista, "No hay plazas disponibles para la fecha elegida. Por favor, seleccione una fecha de vuelta diferente.", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
			
		}		
		
	}

}