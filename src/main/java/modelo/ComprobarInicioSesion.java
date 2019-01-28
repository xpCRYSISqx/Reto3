package modelo;

import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class ComprobarInicioSesion {
	
	Modelo modelo;
	Cliente cliente;
	
	public boolean comprobarInicio(JTextField usuario, JPasswordField contraseña) {
		
		String dni = null;
		String contString;
		char[] cont;
		Encriptacion encriptar = new Encriptacion();
		
		dni = usuario.getText();
		cont = contraseña.getPassword();
		contString = new String(cont);
		contString = encriptar.Encriptacion(contString);
		cliente = modelo.getClienteByDNI(dni);
		if(cliente != null) {
			if(contString.equals(cliente.getContraseña()))
				return true;
			else
				return false;
		}
		else
			return false;
	}
}