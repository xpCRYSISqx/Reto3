package modelo;

import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class ComprobarLogin {
	
	Modelo modelo;
	Cliente cliente;
	
	public boolean comprobarInicio(String usuario, String contrasena, Modelo modelo) {
		
		this.modelo = modelo;
		Encriptacion encriptar = new Encriptacion();
		
		contrasena = encriptar.Encriptacion(contrasena);
		cliente = modelo.consultas.getClienteByDNI(usuario);
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