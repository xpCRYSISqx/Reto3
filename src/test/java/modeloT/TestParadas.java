package modeloT;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Linea;
import modelo.Parada;

public class TestParadas {

	@Test
	public void testConstructorVacioParadas() {
		//Arrange
		Parada geltoki = new Parada();
				
		//Assert
		assertEquals(geltoki.getCodParada(),0);
		assertEquals(geltoki.getNombre(),null);
		assertEquals(geltoki.getCalle(),null);
		assertEquals(geltoki.getLatitud(),0f,0);
		assertEquals(geltoki.getLongitud(),0f,0);
	}
	
	@Test
	public void testConstructorParadas() {
		//Arrange
		Parada geltoki = new Parada(404,"jm parada", "viktor kalea", 43.2000f, -2.90000f);
				
		//Assert
		assertEquals(geltoki.getCodParada(),404);
		assertEquals(geltoki.getNombre(),"jm parada");
		assertEquals(geltoki.getCalle(),"viktor kalea");
		assertEquals(geltoki.getLatitud(),43.2000f,0);
		assertEquals(geltoki.getLongitud(),-2.90000f,0);
	}

}
