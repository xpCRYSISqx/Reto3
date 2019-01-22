package modelo;

public class Autobus {
	
	private String codLinea;
	private String nombre;
	private int[] codAutobuses;
	private int[] codMunicipios;
	
	public Autobus() {
		
	}
	
	public Autobus(String codLinea, String nombre, int[] codAutobuses, int[] codMunicipios) {
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

	public int[] getCodAutobuses() {
		return codAutobuses;
	}

	public void setCodAutobuses(int[] codAutobuses) {
		this.codAutobuses = codAutobuses;
	}

	public int[] getCodMunicipios() {
		return codMunicipios;
	}

	public void setCodMunicipios(int[] codMunicipios) {
		this.codMunicipios = codMunicipios;
	}

}
