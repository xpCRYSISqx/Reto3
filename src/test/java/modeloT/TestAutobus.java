package modeloT;

import static org.junit.Assert.*;
import modelo.*;

import org.junit.Test;

import modelo.Autobus;

public class TestAutobus {

	
	
	@Test
	public void testConstructorVacioAutobus() {
		//Arrange
		Autobus autobus = new Autobus();
		
		//Assert
		assertEquals(autobus.getCodBus(), 0);
		assertEquals(autobus.getNumPlazas(), 0);
		assertEquals(autobus.getConsumo(), 0f, 0);
		assertEquals(autobus.getColor(), null);	
	}
	
	@Test
	public void testConstructorAutobus2() {
		//Arrange
		Autobus autobus = new Autobus(123, 13, 2f, "verde");
		
		//Assert
		assertEquals(autobus.getCodBus(), 123);
		assertEquals(autobus.getNumPlazas(), 13);
		assertEquals(autobus.getConsumo(), 2f, 0);
		assertEquals(autobus.getColor(), "verde");	
	}

}
