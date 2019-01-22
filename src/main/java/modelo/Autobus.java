package modelo;

public class Autobus {
	
	private int codBus;
	private int numPlazas;
	private float consumo;
	private String color;
	
	public Autobus() {
		
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

	public Autobus(int codBus, int numPlazas, float consumo, String color) {
		this.codBus = codBus;
		this.numPlazas = numPlazas;
		this.consumo = consumo;
		this.color = color;
	}

	
}
