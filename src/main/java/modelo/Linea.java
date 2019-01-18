package modelo;

public class Linea {
	
	private int codLinea;
	private int[] codAutobuses;
	private int[] codMunicipios;
	
	public void Linea() {
		
	}
	
	public void Linea(int codLinea, int[] codAutobuses, int[] codMunicipios) {
		this.codLinea = codLinea;
		this.codAutobuses = codAutobuses;
		this.codMunicipios = codMunicipios;
	}

	public int getCodLinea() {
		return codLinea;
	}

	public void setCodLinea(int codLinea) {
		this.codLinea = codLinea;
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
