package modelo;

import java.sql.Date;
/**
 * Este objeto se encarga de almacenar toda la informacion necesaria para registrar y logear a los clientes
 * 
 * @author Elorrieta Errekamari
 * 
 * @param dni: Guarda el DNI del cliente
 * @param nombre: Guarda el nombre del cliente
 * @parma apellidos: Guarda los apellidos del cliente
 * @param fechaNacimiento: Guarda la fecha de nacimiento del cliente
 * @param sexo: Guarda el sexo del cliente, en forma de caracter
 * @param contrasena: Guarda la contraseña del cliente
 * 
 * @return dni: Retorna el DNI del cliente
 * @return nombre: Retorna el nombre del cliente
 * @return apellidos: Retorna los apellidos del cliente
 * @return fechaNacimiento: Retorna la fecha de nacimiento del cliente
 * @return sexo: Retorna el sexo del cliente, en forma de caracter
 * @return contrasena: Retorna la contraseña del cliente
 *
 */
public class Cliente {
	
	private String dni;
	private String nombre;
	private String apellidos;
	private Date fechaNacimiento;
	private char sexo;
	private String contrasena;
	
	public Cliente() {
		
	}
	
	public Cliente(String dni, String nombre, String apellidos, Date fechaNacimiento, char sexo, String contrasena) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.contrasena = contrasena;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}