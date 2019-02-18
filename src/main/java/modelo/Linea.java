package modelo;

import java.util.ArrayList;

/**
 * Clase constructor del objeto "Linea"
 * 
 * @author Uztaritz, Mikel. Laura
 * 
 * @param codLinea: Obtiene el codigo de cada linea
 * @param nombre: Obtiene el nombre de cada linea
 * @param autobuses: Obtiene el autobus de cada linea
 * @param municipio: Obtiene el municipio de cada linea
 * 
 * @return codLinea: Devuelve el codigo de cada linea
 * @return nombre: Devuelve el codigo de cada linea
 * @return autobuses: Devuelve el codigo de cada linea
 * @return municipio: Devuelve el codigo de cada linea
 *  
 */

public class Linea {
	
	private String codLinea;
	private String nombre;
	private ArrayList<Autobus> autobuses;
	private ArrayList<Municipio> municipios;
	
	public Linea() {
	
	}
	
	public Linea(String codLinea, String nombre, ArrayList<Autobus> codAutobuses, ArrayList<Municipio> codMunicipios) {
		this.codLinea = codLinea;
		this.nombre = nombre;
		this.autobuses = codAutobuses;
		this.municipios = codMunicipios;
	}

	public String getCodLinea() {
		return codLinea;
	}

	public void setCodLinea(String codLinea) {
		this.codLinea = codLinea;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Autobus> getAutobuses() {
		return autobuses;
	}

	public void setAutobuses(ArrayList<Autobus> codAutobuses) {
		this.autobuses = codAutobuses;
	}

	public ArrayList<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(ArrayList<Municipio> codMunicipios) {
		this.municipios = codMunicipios;
	}

	@Override
	public String toString() {
		return "Linea " + codLinea + ": " + nombre;
	}
	
	

}
