package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JPanel;

import modelo.ComprobarRegistro;
import modelo.Modelo;
import vista.MainFrame;

public class ControladorRegistro implements ActionListener {
	
	private MainFrame vista;
	private Modelo modelo;
	public static JPanel panelOrigen;
	public static Boolean detalles;
	
	public ControladorRegistro(MainFrame vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		panelOrigen = null;
		detalles = false;
	}
	
	// añadimos listeners a los botones del panel 'registro'
	public void addListeners() {
		vista.registro.btnAtras.addActionListener(this);
		vista.registro.btnCancelar.addActionListener(this);
		vista.registro.btnLogin.addActionListener(this);
		vista.registro.btnRegistro.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand();
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones
		switch (botonPulsado) {
		
			case "Atrás":
				
				panelOrigen.setVisible(true);
				vista.registro.setVisible(false);
				break;
			
			case "Cancelar":
				
				vista.bienvenida.setVisible(true);
				vista.registro.setVisible(false);
				break;
				
			case "Inicio Sesión":
				
				vista.login.setVisible(true);
				vista.registro.setVisible(false);
				ControladorLogin.panelOrigen = panelOrigen;
				break;
				
			case "Registrar":
			
				char sexo = 'n';
				
				// recogemos los datos ingresados por el usuario
				String nombre = vista.registro.txtNombre.getText();
				String apellidos = vista.registro.txtApellidos.getText();
				Date fecha = new Date(vista.registro.dateChooser.getDate().getTime());
				String dni = vista.registro.txtDni.getText();
				boolean femenino = vista.registro.rbtnFem.isSelected();
				boolean masculino = vista.registro.rbtnMasc.isSelected();
				char[] cont = vista.registro.passwordField.getPassword();
				String contrasena = new String(cont);
				char[] contConfirmar = vista.registro.passwordField2.getPassword();
				String contrasenaConfirmar = new String(contConfirmar);
				
				// encriptamos las contraseñas
				contrasena = modelo.encriptacion.Encriptacion(contrasena);
				contrasenaConfirmar = modelo.encriptacion.Encriptacion(contrasenaConfirmar);
				
				// le asignamos el valor adecuado a la variable sexo
				if(femenino)
					sexo = 'M';
				else if(masculino)
					sexo = 'V';
				else
					sexo = 'n';
				
				// registramos al usuario en la BBDD
				ComprobarRegistro comprobar = new ComprobarRegistro();
				int registrado = comprobar.comprobarRegistro(nombre, apellidos, fecha, dni, sexo, contrasena, contrasenaConfirmar, modelo);
				
				// mostramos los errores
				switch(registrado) {
					
					// ningun error, todo correcto!
					case 0:
					
						// ponemos la variable estatica logeado a true
						modelo.logeado = true;
						
						// mostrar la pantalla adecuada
						if(detalles == false) {
							panelOrigen.setVisible(true);
							vista.registro.setVisible(false);
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
						}
						else {
							vista.pago.setVisible(true);
							vista.registro.setVisible(false);
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
						}
					break;
					
					// DNI incorrecto
					case 1:
						vista.registro.lblErrorDNI.setVisible(true);
						vista.registro.lblErrorDNINoIntroducido.setVisible(false);
						vista.registro.lblErrorContrasenas.setVisible(false);
						vista.registro.lblErrorSexo.setVisible(false);
					break;
					
					// Contraseña incorrecta
					case 2:
						vista.registro.lblErrorContrasenas.setVisible(true);
						vista.registro.lblErrorDNI.setVisible(false);
						vista.registro.lblErrorDNINoIntroducido.setVisible(false);
						vista.registro.lblErrorSexo.setVisible(false);
					break;
					
					// Sexo no seleccionado
					case 3:
						vista.registro.lblErrorSexo.setVisible(true);
						vista.registro.lblErrorDNI.setVisible(false);
						vista.registro.lblErrorDNINoIntroducido.setVisible(false);
						vista.registro.lblErrorContrasenas.setVisible(false);
					break;
					
					// DNI no introducido
					case 4:
						vista.registro.lblErrorDNINoIntroducido.setVisible(true);
						vista.registro.lblErrorDNI.setVisible(false);
						vista.registro.lblErrorContrasenas.setVisible(false);
						vista.registro.lblErrorSexo.setVisible(false);
					break;
				}
				
				break;
			}
		
	}
	
}
