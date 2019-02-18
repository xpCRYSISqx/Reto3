package modelo;

import java.util.ArrayList;

/**
 * Objeto linea que se encarga de almacenar la informacion relativa a las lineas
 */

public class Linea {
	
	private String codLinea;
	private String nombre;
	private ArrayList<Autobus> autobuses;
	private ArrayList<Municipio> municipios;
	/**
	 * Contructor vacio del objeto linea
	 */
	public Linea() {
	
	}
	/**
	 * Costructor con parametros del objeto linea
	 * @param codLinea Codigo de la linea
	 * @param nombre Nombre de la linea
	 * @param codAutobuses Codigos de los autobuses de la linea
	 * @param codMunicipios Codigos de los municipios de la linea
	 */
	public Linea(String codLinea, String nombre, ArrayList<Autobus> codAutobuses, ArrayList<Municipio> codMunicipios) {
		this.codLinea = codLinea;
		this.nombre = nombre;
		this.autobuses = codAutobuses;
		this.municipios = codMunicipios;
	}
	/**
	 * Geter del codigo de la linea
	 * 
	 * @return Retorna el codigo de la linea
	 */
	public String getCodLinea() {
		return codLinea;
	}
	/**
	 * Seter del codigo de la linea
	 * 
	 * @param codLinea Codigo de la linea
	 */
	public void setCodLinea(String codLinea) {
		this.codLinea = codLinea;
	}
	/**
	 * Geter del nombre de la linea
	 * 
	 * @return nRetorna el ombre de la linea
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Seter del nomre de la linea
	 * 
	 * @param nombre Nombre de la linea
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Getar de los autobuses
	 * 
	 * @return Retorna los autobuses de la linea
	 */
	public ArrayList<Autobus> getAutobuses() {
		return autobuses;
	}
	/**
	 * Seter de los autobuses de la linea
	 * 
	 * @param codAutobuses Codigo de los autobuses de la linea
	 */
	public void setAutobuses(ArrayList<Autobus> codAutobuses) {
		this.autobuses = codAutobuses;
	}
	/**
	 * Geter de los municipios de la linea
	 * 
	 * @return Retorna los municipios de la linea
	 */
	public ArrayList<Municipio> getMunicipios() {
		return municipios;
	}
	/**
	 * Seter de los municipios de la linea
	 * 
	 * @param codMunicipios Codigo de los municipios de la linea
	 */
	public void setMunicipios(ArrayList<Municipio> codMunicipios) {
		this.municipios = codMunicipios;
	}
	/**
	 * Muestra en la interfaz la linea con un formato especifico
	 */
	@Override
	public String toString() {
		return "Linea " + codLinea + ": " + nombre;
	}
}