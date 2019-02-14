package modelo;

import java.sql.Date;
import modelo.*;

public class ComprobarRegistro {
	
	Modelo modelo;
	Cliente cliente = new Cliente();
	
	public int comprobarRegistro(String nombre, String apellidos, Date fecha, String dni, char sexo, String contraseņa, String contraseņa2, Modelo modelo) {
		this.modelo = modelo;
		boolean sexoSeleccionado;
		if(sexo == 'M')
			sexoSeleccionado = true;
		else if(sexo == 'V')
			sexoSeleccionado = true;
		else
			sexoSeleccionado = false;
		if(sexoSeleccionado == true) {
			if(dni.equals("")) {
				// Al retornar 4 le dice al programa que no se ha introducido un DNI
				return 4;
			}
			else {
				cliente = modelo.consultas.getClienteByDNI(dni);
				if(cliente == null) {
					if(contraseņa.equals(contraseņa2)) {
						cliente = new Cliente(dni, nombre, apellidos, fecha, sexo, contraseņa);
						modelo.consultas.insertarCliente(cliente);
						// Al retornar 0 le dice al programa que todos los datos has sido introducidos correctamente por lo que puede continuar
						return 0;
					}
					else
						// Al retornar 2 le dice al programa que la contraseņa de confirmacion no coincide con la contraseņa introducida
						return 2;
				}
				else
					// Al retornar 1 le dice al programa que el usuario que intenta registrar ya existe, por lo que no puede registrarlo
					return 1;
			}
				
		}
		else
			// Al retornar 3 le dice al programa que el sexo no ha sido seleccionado
			return 3;
	}
}