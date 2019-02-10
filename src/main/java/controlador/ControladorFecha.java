package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

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
				
				vista.detalles_compra.setVisible(true);
				vista.sel_fecha.setVisible(false);
				
				break;
		
		}
		
	}
	
}
