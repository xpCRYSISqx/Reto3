package modeloT;

import static org.junit.Assert.*;
import org.junit.Test;
import modelo.Parada;

public class TestParada {
	
	private int codParada = 404;
	private String nombre = "jm parada";
	private String calle = "viktor kalea";
	private float latitud = 43.2000f;
	private float longitud = -2.90000f;
	private Parada parada = new Parada();

	@Test
	public void testConstructorVacioParadas() {
		//Arrange
		Parada geltoki = new Parada();
				
		//Assert
		assertEquals(0, geltoki.getCodParada());
		assertEquals(null, geltoki.getNombre());
		assertEquals(null, geltoki.getCalle());
		assertEquals(0f, geltoki.getLatitud(), 0);
		assertEquals(0f, geltoki.getLongitud() ,0);
	}
	
	@Test
	public void testConstructorParadas() {
		//Arrange
		Parada geltoki = new Parada(codParada,nombre, calle, latitud, longitud);
				
		//Assert
		assertEquals(codParada, geltoki.getCodParada());
		assertEquals(nombre, geltoki.getNombre());
		assertEquals(calle, geltoki.getCalle());
		assertEquals(latitud, geltoki.getLatitud(), 0);
		assertEquals(longitud, geltoki.getLongitud(), 0);
	}
	
	@Test
	public void testCodParada() {
		parada.setCodParada(codParada);
		assertEquals(codParada, parada.getCodParada());
	}
	
	@Test
	public void testCalle() {
		parada.setCalle(calle);
		assertEquals(calle, parada.getCalle());
	}
	
	
	@Test
	public void testNombre() {
		parada.setNombre(nombre);
		assertEquals(nombre, parada.getNombre());
	}
	
	@Test
	public void testLatitud() {
		parada.setLatitud(latitud);
		assertEquals(latitud, parada.getLatitud(), 0.000001);
	}
	
	@Test
	public void testLongitud() {
		parada.setLongitud(longitud);
		assertEquals(longitud, parada.getLongitud(), 0.000001);
	}
	
	@Test
	public void testToString() {
		parada.setNombre(nombre);
		assertEquals(nombre, parada.toString());
	}

}
