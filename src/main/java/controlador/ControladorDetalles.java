package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


import modelo.Modelo;
import vista.MainFrame;

/**
 * Esta clase controla el panel de detalles y se encarga de enlazar esa parte de la vista con el modelo
 * 
 */
public class ControladorDetalles implements ActionListener {
	
	public MainFrame vista;
	public Modelo modelo;
	/**
	 * Constructor del controlador de detalles
	 * 
	 * @param vista Instancia del main frame para poder utilizarlo
	 * @param modelo Instancia del modelo para poder utilizarlo
	 */
	public ControladorDetalles(MainFrame vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;		
	}
	/**
	 * Creacion de los listeners para los distintos elementos del panel
	 */
	public void addListeners() {
		vista.detalles_compra.btnAtras.addActionListener(this);
		vista.detalles_compra.btnCancelar.addActionListener(this);
		vista.detalles_compra.btnLogin.addActionListener(this);
		vista.detalles_compra.btnRegistro.addActionListener(this);
		vista.detalles_compra.btnContinuar.addActionListener(this);
	}
	/**
	 * Acciones de los distintos componentes del panel
	 */
	public void actionPerformed(ActionEvent e) {
		
		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand();
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones
		switch (botonPulsado) {
		
			case "Atrás":
				
				vista.sel_fecha.setVisible(true);
				vista.detalles_compra.setVisible(false);
				break;
			
			case "Cancelar":
				
				vista.bienvenida.setVisible(true);
				vista.detalles_compra.setVisible(false);
				reset();
				break;
				
			case "Inicio Sesión":
				
				vista.login.setVisible(true);
				vista.detalles_compra.setVisible(false);
				ControladorLogin.panelOrigen = vista.detalles_compra;
				break;
				
			case "Registro":
				
				vista.registro.setVisible(true);
				vista.detalles_compra.setVisible(false);
				ControladorRegistro.panelOrigen = vista.detalles_compra;
				break;
				
			case "Pagar":
				
				ControladorLogin.panelOrigen = vista.detalles_compra;
				ControladorLogin.detalles = true;
				
				float precioIda = this.modelo.billeteIda.getPrecio();
				float precioVuelta = 0;
				
				if (this.modelo.billeteVuelta != null) {
					precioVuelta = this.modelo.billeteVuelta.getPrecio();
				}
				
				this.modelo.precioTotal = precioIda + precioVuelta;
				this.vista.pago.lblDineroTotal.setText(Float.toString(this.modelo.precioTotal) + " €");
				this.vista.pago.lblDineroRest.setText(Float.toString(this.modelo.precioTotal) + " €");
				
				if(modelo.cliente != null) {
					vista.pago.setVisible(true);
					vista.detalles_compra.setVisible(false);
				}
				else {
					vista.login.setVisible(true);
					vista.detalles_compra.setVisible(false);
				}
				
				break;
		
		}
		
	}
	/**
	 * Funciones del boton de clancelar
	 */
	public void reset() {
		modelo.cliente = null;
		modelo.billeteIda = null;
		modelo.billeteVuelta = null;
		modelo.linea = null;
		modelo.paradaOrigen = null;
		modelo.paradaDestino = null;
		modelo.autobus = null;
		modelo.precioTotal = 0;
		
		vista.sel_billete.rbtnIda.setSelected(true);
		vista.sel_billete.rbtnVuelta.setSelected(false);
		
		vista.login.userField.setText("");
		vista.login.password.setText("");
		
		vista.registro.txtNombre.setText("");
		vista.registro.txtApellidos.setText("");
		vista.registro.rbtnMasc.setSelected(false);
		vista.registro.rbtnFem.setSelected(false);
		vista.registro.txtDni.setText("");
		vista.registro.passwordField.setText("");
		vista.registro.passwordField2.setText("");
	}
	
}
