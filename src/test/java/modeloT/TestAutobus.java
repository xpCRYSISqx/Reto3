package modeloT;

import static org.junit.Assert.*;
import modelo.*;

import org.junit.Test;

import modelo.Autobus;

public class TestAutobus {

	
	
	@Test
	public void testConstructorVacioAutobus() {
		//Arrange
		Autobus Autobus = new Autobus();
		
		//Assert
		assertEquals(Autobus.getCodBus(), 0);
		assertEquals(Autobus.getNumPlazas(), 0);
		assertEquals(Autobus.getConsumo(), 0f, 0);
		assertEquals(Autobus.getColor(), null);	
	}
	
	@Test
	public void testConstructorAutobus2() {
		//Arrange
		Autobus Autobus = new Autobus(123, 13, 2f, "verde");
		
		//Assert
		assertEquals(Autobus.getCodBus(), 123);
		assertEquals(Autobus.getNumPlazas(), 13);
		assertEquals(Autobus.getConsumo(), 2f, 0);
		assertEquals(Autobus.getColor(), "verde");	
	}

}
