package modelo;

import java.util.ArrayList;

/**
 * Clase constructor del objeto "Municipio"
 * 
 * @author Uztaritz, Mikel. Laura
 * 
 * @param nombre: Obtiene el nombre de cada municipio
 * @param codPostal: Obtiene el codigo postal de cada municipio
 * @param codParadas: Obtiene el codigo de municipio
 *
 * @return nombre: Devuelve el nombre del municipio solicitado
 * @return codPostal: Devuelve el codigo postal del municipio solicitado
 * @return codParadas: Devuelve la codigo del municipio solicitado
 *  
 */

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