package modelo;

import java.sql.Date;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class ComprobarRegistro {
	
	Consultas consultas;
	Cliente cliente;
	
	public int comprobarRegistro(JTextField nombre0, JTextField apellidos0, JDateChooser fecha0, JTextField dni0,JRadioButton femenino0, JRadioButton masculino, JPasswordField contraseña, JPasswordField contraseña2) {
		String dni = null;
		String contString;
		String contStringConfirmar;
		String nombre;
		String apellidos;
		Date fecha;
		boolean femenino;
		char sexo;
		char[] cont;
		char[] contConfirmar;
		Encriptacion encriptar = new Encriptacion();
		
		dni = dni0.getText();
		nombre = nombre0.getText();
		apellidos = apellidos0.getText();
		cont = contraseña.getPassword();
		contString = new String(cont);
		contString = encriptar.Encriptacion(contString);
		contConfirmar = contraseña2.getPassword();
		contStringConfirmar = new String(contConfirmar);
		contStringConfirmar = encriptar.Encriptacion(contStringConfirmar);
		femenino = femenino0.isSelected();
		if(femenino == true)
			sexo = 'M';
		else
			sexo = 'V';
		cliente = consultas.getClienteByDNI(dni);
		if(cliente == null) {
			if(contString.equals(contStringConfirmar)) {
				fecha = (Date) fecha0.getDate();
				cliente = new Cliente(dni, nombre, apellidos, fecha, sexo, contString);
				// Al retornar 0 le dice al programa que todos los datos has sido introducidos correctamente por lo que puede continuar
				return 0;
			}
			else
				// Al retornar 2 le dice al programa que la contraseña de confirmacion no coincide con la contraseña introducida
				return 2;
		}
		else
			// Al retornar 1 le dice al programa que el usuario que intenta registrar ya existe, por lo que no puede registrarlo
			return 1;
	}
}