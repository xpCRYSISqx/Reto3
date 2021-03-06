package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Modelo;
import vista.MainFrame;

/**
 * Esta clase controla las distintas funciones de la ventana de inicio de sesion
 */

public class ControladorLogin implements ActionListener {
	
	private MainFrame vista; // Instancia del MainFrame.
	private Modelo modelo; // Instancia del Modelo.
	public static JPanel panelOrigen; // Guarda el panel del que se viene al panel de registro.
	public static Boolean detalles; // Indica si se viene de la ventana de detalles.
	/**
	 * Constructor del controlador de inicio de sesion
	 * 
	 * @param vista Guarda el objeto vista para poder utilizar los distintos elementos de la interfaz
 	 * @param modelo Guarda el objeto modelo para poder acceder a los metodos del modelo
	 */
	public ControladorLogin(MainFrame vista, Modelo modelo) { // Constructor
		this.vista = vista;
		this.modelo = modelo;
		panelOrigen = null;
		detalles = false;
	}
	/**
	 * Creamos los listeners del panel de inicio de sesion
	 */
	public void addListeners() {
		vista.login.btnAtras.addActionListener(this);
		vista.login.btnCancelar.addActionListener(this);
		vista.login.btnRegistro.addActionListener(this);
		vista.login.btnLogin.addActionListener(this);
	}
	/**
	 * Metodo que designa la accion realizada por cada listener
	 */
	public void actionPerformed(ActionEvent e) { // Acciones de los botones de la ventana de inicio de sesion.
		
		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand();
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones.
		switch (botonPulsado) {
		
			case "Atr�s":
				
				panelOrigen.setVisible(true);
				vista.login.setVisible(false);
				break;
			
			case "Cancelar":
				
				vista.bienvenida.setVisible(true);
				vista.login.setVisible(false);
				reset();
				break;
				
			case "Registro":
				
				vista.registro.setVisible(true);
				vista.login.setVisible(false);
				ControladorRegistro.panelOrigen = panelOrigen;
				break;
				
			case "Iniciar Sesi�n":
				
				// recogemos los datos ingresados por el usuario
				String dni = vista.login.userField.getText(); // Recoge el dni que ha sido introducido desde la interfaz.
				char[] cont = vista.login.password.getPassword(); // Recoge la contrase�a que ha sido introducida desde la interfaz.
				String contString = new String(cont); // Transforma la contrase�a que esta en un array de caracteres a String.
				
				// comprobamos si el usuario esta registrado
				modelo.cliente = modelo.funcionesRegistro.comprobarInicio(dni, contString); // Llamada a la funcion comprobarInicio.
			
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
					JOptionPane.showMessageDialog(vista, "Datos err�neos. Int�ntelo de nuevo", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
				break;
		}
	}
	/**
	 * Metodo del boton de cancelar del panel de inicio de sesion
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