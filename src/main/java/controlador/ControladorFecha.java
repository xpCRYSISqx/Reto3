package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import modelo.Modelo;
import vista.MainFrame;

public class ControladorFecha implements ActionListener {
	
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
	
}
