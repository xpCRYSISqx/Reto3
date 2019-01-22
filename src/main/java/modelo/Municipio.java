package modelo;

public class Municipio {
	
	private String nombre;
	private int codPostal;
	private int[] codParadas;
	
	public Municipio() {
		
	}
	
	public Municipio(String nombre, int codPostal, int[] codParadas) {
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

	public int[] getCodParadas() {
		return codParadas;
	}

	public void setCodParadas(int[] codParadas) {
		this.codParadas = codParadas;
	}

	
}
