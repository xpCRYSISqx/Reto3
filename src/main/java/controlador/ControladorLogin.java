package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import modelo.ComprobarInicioSesion;
import modelo.Modelo;
import vista.MainFrame;

public class ControladorLogin implements ActionListener {
	
	private MainFrame vista;
	private Modelo modelo;
	public static JPanel panelOrigen;
	public static Boolean pagar;
	
	public ControladorLogin(MainFrame vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		panelOrigen = null;
		pagar = false;
	}
	
	// añadimos listeners a los botones del panel 'login'
	public void addListeners() {
		vista.login.btnAtras.addActionListener(this);
		vista.login.btnCancelar.addActionListener(this);
		vista.login.btnRegistro.addActionListener(this);
		vista.login.btnLogin.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		
		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand();
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones
		switch (botonPulsado) {
		
			case "Atrás":
				panelOrigen.setVisible(true);
				vista.login.setVisible(false);
				break;
			
			case "Cancelar":
				
				vista.bienvenida.setVisible(true);
				vista.login.setVisible(false);
				break;
				
			case "Registro":
				
				vista.registro.setVisible(true);
				vista.login.setVisible(false);
				ControladorRegistro.panelOrigen = panelOrigen;
				break;
				
			case "Iniciar Sesión":
				
				// recogemos los datos ingresados por el usuario
				String dni = vista.login.userField.getText();
				char[] cont = vista.login.password.getPassword();
				String contString = new String(cont);
				
				// comprobamos si el usuario esta registrado
				ComprobarInicioSesion comprobar = new ComprobarInicioSesion();
				Controlador.logeado = comprobar.comprobarInicio(dni, contString);
			
				// mostramos la pantalla adecuada
				if(Controlador.logeado == true) {
					
					vista.login.lblError.setVisible(false);
					
					// mostrar la pantalla adecuada
					if(pagar == false) {
						panelOrigen.setVisible(true);
						vista.login.setVisible(false);
					}
					else {
						vista.pago.setVisible(true);
						vista.login.setVisible(false);
					}
					
				} else {
					vista.login.lblError.setVisible(true);
				}
				
				break;
		
		}
		
	}
	
}
