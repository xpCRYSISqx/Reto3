package modeloT;

import static org.junit.Assert.*;
import org.junit.Test;
import modelo.Autobus;
public class TestAutobus {
	
	private int codBus = 123;
	private int numPlazas = 13;
	private float consumo = 2.5f;
	private String color = "verde";
	private Autobus autobus = new Autobus();
	
	@Test
	public void testConstructorVacioAutobus() {
		//Arrange
		Autobus autobus = new Autobus();
		
		//Assert
		assertEquals(0, autobus.getCodBus());
		assertEquals(0, autobus.getNumPlazas());
		assertEquals(0f, autobus.getConsumo(), 0);
		assertEquals(null, autobus.getColor());	
	}
	
	@Test
	public void testConstructorAutobus2() {
		//Arrange
		Autobus autobus = new Autobus(codBus, numPlazas, consumo, color);
		
		//Assert
		assertEquals(codBus, autobus.getCodBus());
		assertEquals(numPlazas, autobus.getNumPlazas());
		assertEquals(consumo, autobus.getConsumo(), 0);
		assertEquals(color, autobus.getColor());	
	}
	
	@Test
	public void testCodBus() {
		autobus.setCodBus(codBus);
		assertEquals(codBus, autobus.getCodBus());
	}
	
	@Test
	public void testNumPlazas() {
		autobus.setNumPlazas(numPlazas);
		assertEquals(numPlazas, autobus.getNumPlazas());
	}
	
	@Test
	public void testConsumo() {
		autobus.setConsumo(consumo);
		assertEquals(consumo, autobus.getConsumo(), 0.000001);
	}
	
	@Test
	public void testColor() {
		autobus.setColor(color);
		assertEquals(color, autobus.getColor());
	}

}
