package modelo;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ComprobarRegistro {
	
	Modelo modelo;
	Cliente cliente;
	
	public int comprobarRegistro(JTextField nombre, JTextField apellidos, JTextField dni0, JPasswordField contraseña, JPasswordField contraseña2) {
		String dni = null;
		String contString;
		String contStringConfirmar;
		char[] cont;
		char[] contConfirmar;
		Encriptacion encriptar = new Encriptacion();
		
		dni = dni0.getText();
		cont = contraseña.getPassword();
		contString = new String(cont);
		contString = encriptar.Encriptacion(contString);
		contConfirmar = contraseña2.getPassword();
		contStringConfirmar = new String(contConfirmar);
		contStringConfirmar = encriptar.Encriptacion(contStringConfirmar);
		
		cliente = modelo.getClienteByDNI(dni);
		if(cliente == null) {
			if(contString.equals(contStringConfirmar))
				// Al retornar 0 le dice al programa que todos los datos has sido introducidos correctamente por lo que puede continuar
				return 0;
			else
				// Al retornar 2 le dice al programa que la contraseña de confirmacion no coincide con la contraseña introducida
				return 2;
		}
		else
			// Al retornar 1 le dice al programa que el usuario que intenta registrar ya existe, por lo que no puede registrarlo
			return 1;
	}
}