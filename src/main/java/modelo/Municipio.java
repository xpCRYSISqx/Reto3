package modelo;

import java.util.ArrayList;

/**
 * Objeto municipio que se encarga de almacenar los datos relativos al municipio
 */

public class Municipio {
	
	private String nombre;
	private int codPostal;
	private ArrayList<Integer> codParadas;
	/**
	 * Constructor vacio del objeto
	 */
	public Municipio() {
		
	}
	/**
	 * Constructor con parametros del objeto
	 * 
	 * @param nombre Nombre del municipio
	 * @param codPostal Codigo postal del municipio
	 * @param codParadas Codigo de las paradas del municipio
	 */
	public Municipio(String nombre, int codPostal, ArrayList<Integer> codParadas) {
		this.nombre = nombre;
		this.codPostal = codPostal;
		this.codParadas = codParadas;
	}
	/**
	 * Geter del nombre del municipio
	 * 
	 * @return Retorna el nombre del municipio
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Seter del nombre del municipio
	 * 
	 * @param nombre Nombre del municipio
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Geter del codigo postal del municipio
	 * 
	 * @return Retorna el codigo postal del municipio
	 */
	public int getCodPostal() {
		return codPostal;
	}
	/**
	 * Seter del codigo postal del municipio
	 * 
	 * @param codPostal Codigo postal del municipio
	 */
	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}
	/**
	 * Geter de los codigos de las paradas del municipio
	 * 
	 * @return Retorna los codigos de las paradas del municipio
	 */
	public ArrayList<Integer> getCodParadas() {
		return codParadas;
	}
	/**
	 * Seter de los codigos de las paradas del municipio
	 * 
	 * @param codParadas Codigo de las paradas del municipio
	 */
	public void setCodParadas(ArrayList<Integer> codParadas) {
		this.codParadas = codParadas;
	}	
}