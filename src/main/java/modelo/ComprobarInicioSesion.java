package modelo;

import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class ComprobarInicioSesion {
	
	Consultas consultas;
	Cliente cliente;
	
	public boolean comprobarInicio(String usuario, String contrasena) {
		
		Encriptacion encriptar = new Encriptacion();
		
		contrasena = encriptar.Encriptacion(contrasena);
		cliente = consultas.getClienteByDNI(usuario);
		if(cliente != null) {
			if(contrasena.equals(cliente.getContraseña())) {
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
}