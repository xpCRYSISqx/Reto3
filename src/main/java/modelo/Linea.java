package modelo;

import java.util.ArrayList;

public class Linea {
	
	private String codLinea;
	private String nombre;
	private ArrayList<Integer> codAutobuses;
	private ArrayList<Integer> codMunicipios;
	
	public Linea() {
		
	}
	
	public Linea(String codLinea, String nombre, ArrayList<Integer> codAutobuses, ArrayList<Integer> codMunicipios) {
		this.codLinea = codLinea;
		this.nombre = nombre;
		this.codAutobuses = codAutobuses;
		this.codMunicipios = codMunicipios;
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

	public ArrayList<Integer> getCodAutobuses() {
		return codAutobuses;
	}

	public void setCodAutobuses(ArrayList<Integer> codAutobuses) {
		this.codAutobuses = codAutobuses;
	}

	public ArrayList<Integer> getCodMunicipios() {
		return codMunicipios;
	}

	public void setCodMunicipios(ArrayList<Integer> codMunicipios) {
		this.codMunicipios = codMunicipios;
	}

}
