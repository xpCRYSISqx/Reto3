package modelo;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ComprobarRegistro {
	
	Modelo modelo;
	Cliente cliente;
	
	public int comprobarRegistro(JTextField nombre, JTextField apellidos, JTextField dni0, JPasswordField contrase�a, JPasswordField contrase�a2) {
		String dni = null;
		String contString;
		String contStringConfirmar;
		char[] cont;
		char[] contConfirmar;
		Encriptacion encriptar = new Encriptacion();
		
		dni = dni0.getText();
		cont = contrase�a.getPassword();
		contString = new String(cont);
		contString = encriptar.Encriptacion(contString);
		contConfirmar = contrase�a2.getPassword();
		contStringConfirmar = new String(contConfirmar);
		contStringConfirmar = encriptar.Encriptacion(contStringConfirmar);
		
		cliente = modelo.getClienteByDNI(dni);
	}
}