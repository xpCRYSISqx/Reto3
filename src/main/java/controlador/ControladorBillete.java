package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import modelo.Modelo;
import vista.MainFrame;

public class ControladorBillete implements ActionListener {
	
	public MainFrame vista;
	public Modelo modelo;
	
	public ControladorBillete(MainFrame vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;		
	}
	
	// añadimos listeners a los botones del panel 'sel_billete'
	public void addListeners() {
		vista.sel_billete.btnAtras.addActionListener(this);
		vista.sel_billete.btnCancelar.addActionListener(this);
		vista.sel_billete.btnLogin.addActionListener(this);
		vista.sel_billete.btnRegistro.addActionListener(this);
		vista.sel_billete.btnContinuar.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand();
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones
		switch (botonPulsado) {
		
			case "Atrás":
				
				vista.sel_linea.setVisible(true);
				vista.sel_billete.setVisible(false);
				break;
			
			case "Cancelar":
				
				vista.bienvenida.setVisible(true);
				vista.sel_billete.setVisible(false);
				break;
				
			case "Inicio Sesión":
				
				vista.login.setVisible(true);
				vista.sel_billete.setVisible(false);
				ControladorLogin.panelOrigen = vista.sel_billete;
				break;
				
			case "Registro":
				
				vista.registro.setVisible(true);
				vista.sel_billete.setVisible(false);
				ControladorRegistro.panelOrigen = vista.sel_billete;
				break;
				
			case "Continuar":
				
				vista.sel_fecha.setVisible(true);
				vista.sel_billete.setVisible(false);
				vista.sel_fecha.txtOrigen.removeAll();
				vista.sel_fecha.txtDestino.removeAll();
				String origen = (String) vista.sel_billete.listaOrigen.getSelectedValue();
				String destino = (String) vista.sel_billete.listaDestino.getSelectedValue();
				
				vista.sel_fecha.txtOrigen.setText(origen);
				vista.sel_fecha.txtDestino.setText(destino);
				
				break;
		
		}
		
	}
	
}
