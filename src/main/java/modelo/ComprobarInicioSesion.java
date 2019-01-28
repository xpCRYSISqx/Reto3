package modelo;

import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class ComprobarInicioSesion {
	
	Modelo modelo;
	Cliente cliente;
	
	public boolean comprobarInicio(JTextField usuario, JPasswordField contrase�a) {
		
		String dni = null;
		String contString;
		char[] cont;
		Encriptacion encriptar = new Encriptacion();
		
		dni = usuario.getText();
		cont = contrase�a.getPassword();
		contString = new String(cont);
		contString = encriptar.Encriptacion(contString);
		cliente = modelo.getClienteByDNI(dni);
		if(cliente != null) {
			if(contString.equals(cliente.getContrase�a()))
				return true;
			else
				return false;
		}
		else
			return false;
	}
}