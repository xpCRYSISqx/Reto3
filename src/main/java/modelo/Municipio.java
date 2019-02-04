package modelo;

import java.util.ArrayList;

public class Municipio {
	
	private String nombre;
	private int codPostal;
	private ArrayList<Integer> codParadas;
	
	public Municipio() {
		
	}
	
	public Municipio(String nombre, int codPostal, ArrayList<Integer> codParadas) {
		this.nombre = nombre;
		this.codPostal = codPostal;
		this.codParadas = codParadas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}

	public ArrayList<Integer> getCodParadas() {
		return codParadas;
	}

	public void setCodParadas(ArrayList<Integer> codParadas) {
		this.codParadas = codParadas;
	}	
}