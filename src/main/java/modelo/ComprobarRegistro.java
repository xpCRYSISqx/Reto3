package modelo;

import java.sql.Date;

public class ComprobarRegistro {
	
	Consultas consultas;
	Cliente cliente;
	
	public int comprobarRegistro(String nombre, String apellidos, Date fecha, String dni, char sexo, String contraseņa, String contraseņa2) {
		boolean sexoSeleccionado;
		if(sexo == 'M')
			sexoSeleccionado = true;
		else if(sexo == 'V')
			sexoSeleccionado = true;
		else
			sexoSeleccionado = false;
		if(sexoSeleccionado == true) {
			cliente = consultas.getClienteByDNI(dni);
			if(cliente == null) {
				if(contraseņa.equals(contraseņa2)) {
					cliente = new Cliente(dni, nombre, apellidos, fecha, sexo, contraseņa);
					consultas.insertarCliente(cliente);
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
		else
			// Al retornar 3 le dice al programa que el sexo no ha sido seleccionado
			return 3;
	}
}