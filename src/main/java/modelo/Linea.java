package modelo;

import java.util.ArrayList;

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
