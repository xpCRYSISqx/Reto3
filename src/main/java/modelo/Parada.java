package modelo;

/**
 * Clase constructor del objeto "Parada"
 * 
 * @author Uztaritz, Mikel. Laura
 * 
 * @param codParada: Obtiene el código de cada parada
 * @param nombre: Obtiene el nombre de cada parada
 * @param calle: Obtiene la calle de cada parada
 * @param latitud: Obtiene el latitud de cada parada
 * @param longitud: Obtiene el longitud de cada parada
 * 
 * @return codParada: Devuelve el código de la parada solicitada
 * @return nombre: Devuelve el nombre de la parada solicitada
 * @return calle: Devuelve la calle de la parada solicitada
 * @return latitud: Devuelve el latitud de la parada solicitada
 * @return longitud: Devuelve el longitud de la parada solicitada  
 *  
 */

public class Parada {
	
	private int codParada;
	private String nombre;
	private String calle;
	private float latitud;
	private float longitud;
	
	public Parada() {
		
	}
	
	public Parada(int codParada, String nombre, String calle, float latitud, float longitud) {
		this.codParada = codParada;
		this.nombre = nombre;
		this.calle = calle;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public int getCodParada() {
		return codParada;
	}

	public void setCodParada(int codParada) {
		this.codParada = codParada;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
}