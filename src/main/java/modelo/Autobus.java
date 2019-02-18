package modelo;

/**
 * Objeto que se encarga de almacenar los atributos del autobus
 * 
 * @author Laura, Ustaritz, Mikel
 * 
 * @param codBus: Parametro que guarda el codigo del autobus
 * @param numPlazas: Guarda el numero de plazas del autobus
 * @param consumo: Guarda el consumo del autobus
 * @param color: Guarda el color del autobus
 * 
 * @return codBus: Retorna el codigo del autobus para poder utilizarlo
 * @return numPlazas: Retorna el numero de plazas para poder utilizarlo
 * @return consumo: Retorna el consumo del autobus para poder hacer calculos con el
 * @return color: Retorna el color del autobus
 *
 */

public class Autobus {
	
	private int codBus;
	private int numPlazas;
	private float consumo;
	private String color;
	
	public Autobus() {
		
	}
	
	public Autobus(int codBus, int numPlazas, float consumo, String color) {
		this.codBus = codBus;
		this.numPlazas = numPlazas;
		this.consumo = consumo;
		this.color = color;
	}
	
	public int getCodBus() {
		return codBus;
	}

	public void setCodBus(int codBus) {
		this.codBus = codBus;
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	public float getConsumo() {
		return consumo;
	}

	public void setConsumo(float consumo) {
		this.consumo = consumo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}