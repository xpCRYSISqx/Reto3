package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


import modelo.Modelo;
import vista.MainFrame;

public class ControladorDetalles implements ActionListener {
	
	public MainFrame vista;
	public Modelo modelo;
	
	public ControladorDetalles(MainFrame vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;		
	}
	
	// añadimos listeners a los botones del panel 'detalles_compra'
	public void addListeners() {
		vista.detalles_compra.btnAtras.addActionListener(this);
		vista.detalles_compra.btnCancelar.addActionListener(this);
		vista.detalles_compra.btnLogin.addActionListener(this);
		vista.detalles_compra.btnRegistro.addActionListener(this);
		vista.detalles_compra.btnContinuar.addActionListener(this);
	}
	
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
	
}
