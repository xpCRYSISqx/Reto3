package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import modelo.Cliente;
import modelo.Modelo;
import vista.MainFrame;

public class ControladorRegistro implements ActionListener {
	
	private MainFrame vista;
	private Modelo modelo;
	
	private String nombre;
	private String apellidos;
	private String dni;
	private Date fecha;
	private char sexo;
	private String contrasena;
	private String contrasena2;
	
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
				
				if(validarDatos()) {
					
					if(modelo.consultas.getClienteByDNI(dni) != null) {
						JOptionPane.showMessageDialog(vista, "Ya existe un usuario con DNI " + this.dni, "Aviso", JOptionPane.WARNING_MESSAGE);
					} else {
						modelo.cliente = new Cliente(dni, nombre, apellidos, fecha, sexo, contrasena);
						modelo.consultas.insertarCliente(modelo.cliente);
					}	
					
					// actualizar pantalla
					if(modelo.cliente != null) {
					
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
						
						// mostrar la pantalla adecuada
						if(detalles == false) {
							panelOrigen.setVisible(true);
							vista.registro.setVisible(false);
						}
						else {
							vista.pago.setVisible(true);
							vista.registro.setVisible(false);
						}
					
					}
					
				}
				
				break;
			}
		
	}
	
	
	public boolean validarDatos() {
		
		String nombre = vista.registro.txtNombre.getText();
		String apellidos = vista.registro.txtApellidos.getText();
		JDateChooser fecha = vista.registro.dateChooser;
		boolean femenino = vista.registro.rbtnFem.isSelected();
		boolean masculino = vista.registro.rbtnMasc.isSelected();
		String dni = vista.registro.txtDni.getText();
		char[] contrasena = vista.registro.passwordField.getPassword();
		char[] contrasena2 = vista.registro.passwordField2.getPassword();
		
		// comprobamos que el nombre no este vacio
		if (nombre.equals("")) {
			JOptionPane.showMessageDialog(vista, "Nombre no introducido.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			this.nombre = nombre;
		}
		
		// comprobamos que el apellido no este vacio
		if (apellidos.equals("")) {
			JOptionPane.showMessageDialog(vista, "Apellido no introducido.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			this.apellidos = apellidos;
		}
		
		// comprobamos que se ha seleccionado una fecha
		if (fecha.getDate() == null) {
			JOptionPane.showMessageDialog(vista, "Ninguna fecha seleccionada.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			this.fecha = new Date(fecha.getDate().getTime());
		}
		
		// comprobamos que haya sido seleccionado un sexo y le asignamos el valor adecuado a la variable
		if (!femenino && !masculino) {
			JOptionPane.showMessageDialog(vista, "Sexo no seleccionado.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (femenino) {
			this.sexo = 'M';
		} else {
			this.sexo = 'V';
		}
		
		// comprobamos que el dni no este vacio
		if (dni.equals("")) {
			JOptionPane.showMessageDialog(vista, "DNI no introducido.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			this.dni = dni;
		}
				
		// comprobamos que la contraseña no este vacia
		if (contrasena.length == 0) {
			JOptionPane.showMessageDialog(vista, "Contraseña no introducida.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		// comprobamos que la contraseña2 no este vacia
		if (contrasena2.length == 0) {
			JOptionPane.showMessageDialog(vista, "Confirmar contraseña no introducida.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		// comprobamos que las dos contraseñas sean iguales
		if(!contrasena.equals(contrasena2)) {
			JOptionPane.showMessageDialog(vista, "Las contraseñas no son iguales", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			this.contrasena = String.valueOf(contrasena);
			this.contrasena = modelo.encriptacion.Encriptacion(this.contrasena);
		}
		
		return true;
		
	}
	
}
