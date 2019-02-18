package modelo;

/**
 * Objeto que se encarga de almacenar los atributos del autobus
 */

public class Autobus {
	
	private int codBus;
	private int numPlazas;
	private float consumo;
	private String color;
	/**
	 * Constructor vacio de autobus
	 */
	public Autobus() {
		
	}
	/**
	 * Constructor con parametros de autobus
	 * 
	 * @param codBus: Parametro que guarda el codigo del autobus
	 * @param numPlazas: Guarda el numero de plazas del autobus
	 * @param consumo: Guarda el consumo del autobus
	 * @param color: Guarda el color del autobus
	 */
	public Autobus(int codBus, int numPlazas, float consumo, String color) {
		this.codBus = codBus;
		this.numPlazas = numPlazas;
		this.consumo = consumo;
		this.color = color;
	}
	/**
	 * Geter del codigo del autobus
	 * 
	 * @return Retorna el codigo del autobus para poder utilizarlo
	 */
	public int getCodBus() {
		return codBus;
	}
	/**
	 * Seter del codigo del autobus
	 * 
	 * @param codBus Parametro que guarda el codigo del autobus
	 */
	public void setCodBus(int codBus) {
		this.codBus = codBus;
	}
	/**
	 * Geter del numero de plazas
	 * 
	 * @return Retorna el numero de plazas para poder utilizarlo
	 */
	public int getNumPlazas() {
		return numPlazas;
	}
	/**
	 * Seter del numero de plazas
	 * 
	 * @param numPlazas Guarda el numero de plazas del autobus
	 */
	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}
	/**
	 * Geter del consumo del autobus
	 * 
	 * @return Retorna el consumo del autobus para poder hacer calculos con el
	 */
	public float getConsumo() {
		return consumo;
	}
	/**
	 * Seter del consumo del autobus
	 * 
	 * @param consumo Guarda el consumo del autobus
	 */
	public void setConsumo(float consumo) {
		this.consumo = consumo;
	}
	/**
	 * Geter del color del autobus
	 * 
	 * @return Retorna el color del autobus
	 */
	public String getColor() {
		return color;
	}
	/**
	 * Seter del color del autobus
	 * 
	 * @param color Guarda el color del autobus
	 */
	public void setColor(String color) {
		this.color = color;
	}
}