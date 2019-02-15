package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.ComprobarLogin;
import modelo.Modelo;
import vista.MainFrame;

/**
 * Esta clase controla las distintas funciones de la ventana de inicio de sesion
 * 
 * @author Mikel, Ustaritz, Laura
 * 
 * @param vista: Guarda el objeto vista para poder utilizar los distintos elementos de la interfaz.
 * @param modelo: Guarda el objeto modelo para poder acceder a los metodos del modelo.
 * @param panelOrigen: Esta variable guarda la ventana desde la cual se ha ido al panel de inicio de sesion.
 * @param detalles: Si se viene del panel de detalles, esta variable es true, si no es false. Sirve para saber si una vez logeado tiene que pasar a la ventana de pago o continuar en la que estaba.
 * 
 *
 */

public class ControladorLogin implements ActionListener {
	
	private MainFrame vista; // Instancia del MainFrame.
	private Modelo modelo; // Instancia del Modelo.
	public static JPanel panelOrigen; // Guarda el panel del que se viene al panel de registro.
	public static Boolean detalles; // Indica si se viene de la ventana de detalles.
	
	public ControladorLogin(MainFrame vista, Modelo modelo) { // Constructor
		this.vista = vista;
		this.modelo = modelo;
		panelOrigen = null;
		detalles = false;
	}
	
	// añadimos listeners a los botones del panel 'login'
	public void addListeners() {
		vista.login.btnAtras.addActionListener(this);
		vista.login.btnCancelar.addActionListener(this);
		vista.login.btnRegistro.addActionListener(this);
		vista.login.btnLogin.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) { // Acciones de los botones de la ventana de inicio de sesion.
		
		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand();
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones.
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
				String dni = vista.login.userField.getText(); // Recoge el dni que ha sido introducido desde la interfaz.
				char[] cont = vista.login.password.getPassword(); // Recoge la contraseña que ha sido introducida desde la interfaz.
				String contString = new String(cont); // Transforma la contraseña que esta en un array de caracteres a String.
				
				// comprobamos si el usuario esta registrado
				ComprobarLogin comprobar = new ComprobarLogin(); // Instancia de la clase ComprobarLogin.
				modelo.cliente = comprobar.comprobarInicio(dni, contString, modelo); // Llamada a la funcion comprobarInicio.
			
				// mostramos la pantalla adecuada
				if(modelo.cliente != null) { // Comprueba si hay un cliente.
					// deshabilitar botones de login y registro en todos los paneles
					vista.sel_billete.btnLogin.setVisible(false);
					vista.sel_billete.btnLogin.setEnabled(false);
					vista.sel_billete.btnRegistro.setVisible(false);
					vista.sel_billete.btnRegistro.setEnabled(false);
					vista.sel_fecha.btnLogin.setVisible(false);
					vista.sel_fecha.btnLogin.setEnabled(false);
					vista.sel_fecha.btnRegistro.setVisible(false);
					vista.sel_fecha.btnRegistro.setEnabled(false);
					vista.detalles_compra.btnLogin.setVisible(false);
					vista.detalles_compra.btnLogin.setEnabled(false);
					vista.detalles_compra.btnRegistro.setVisible(false);
					vista.detalles_compra.btnRegistro.setEnabled(false);
					
					if(detalles == false) {
						
						// mostrar la pantalla adecuada
						panelOrigen.setVisible(true);
						vista.login.setVisible(false);
					}
					else {
						
						// mostrar la pantalla adecuada
						vista.pago.setVisible(true);
						vista.login.setVisible(false);
					}
					
				} else {
					JOptionPane.showMessageDialog(vista, "Datos erróneos. Inténtelo de nuevo", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
				break;
		}
	}
}