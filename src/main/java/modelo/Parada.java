package modelo;

/**
 * Objeto parada que se encarga de almacenar la informacion relativa a las paradas
 */

public class Parada {
	
	private int codParada;
	private String nombre;
	private String calle;
	private float latitud;
	private float longitud;
	/**
	 * Constructor vacio del objeto
	 */
	public Parada() {
		
	}
	/**
	 * Constructor con parametros del objeto
	 * 
	 * @param codParada Codigo de la parada
	 * @param nombre Nombre de la parada
	 * @param calle Calle en la que se encuentra la parada
	 * @param latitud Latitud en la que se encuentra la parada
	 * @param longitud Longitud en la que se encuentra la parada
	 */
	public Parada(int codParada, String nombre, String calle, float latitud, float longitud) {
		this.codParada = codParada;
		this.nombre = nombre;
		this.calle = calle;
		this.latitud = latitud;
		this.longitud = longitud;
	}
	/**
	 * Geter del codigo de la parada
	 * 
	 * @return Retorna el codigo de la parada
	 */
	public int getCodParada() {
		return codParada;
	}
	/**
	 * Seter del codigo de la parada
	 * 
	 * @param codParada Codigo de la parada
	 */
	public void setCodParada(int codParada) {
		this.codParada = codParada;
	}
	/**
	 * Geter del nombre de la parada
	 * 
	 * @return Retorna el nombre de la parada
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Seter del nombre de la parada
	 * 
	 * @param nombre Nombre de la parada
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Geter de la calle de la parada
	 * 
	 * @return Reotrna la calle en la que se encuentra la parada
	 */
	public String getCalle() {
		return calle;
	}
	/**
	 * Seter de la calle de la parada
	 * 
	 * @param calle Calle en la que se encuentra la parada
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}
	/**
	 * Geter de la latitud
	 * 
	 * @return Retorna la latitud en la que se encuentra la parada
	 */
	public float getLatitud() {
		return latitud;
	}
	/**
	 * Seter de la latitud
	 * 
	 * @param latitud Latitud en la que se encuentra la parada
	 */
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	/**
	 * Geter de la longitud
	 * 
	 * @return Reotrna la longitud en la que se encuentra la parada
	 */
	public float getLongitud() {
		return longitud;
	}
	/**
	 * Seter de la longitud
	 * 
	 * @param longitud Longitud en la que se encuentra la parada
	 */
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	/**
	 * Metodo que le da formato al nombre para poder mostrarlo en la interfaz
	 */
	@Override
	public String toString() {
		return nombre;
	}
	
	
}