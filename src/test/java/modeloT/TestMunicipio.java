package modeloT;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import modelo.Municipio;

public class TestMunicipio {
	
	private String nombre = "Migaralles";
	private int codPostal = 48490;
	private ArrayList<Integer> codParadas = new ArrayList<Integer>();
	private Municipio municipio = new Municipio();

	@Test
	public void testConstructorVacioMunicipio() {
		//Arrange
		Municipio pueblo = new Municipio();
				
		//Assert
		assertEquals(null, pueblo.getNombre());
		assertEquals(0, pueblo.getCodPostal());
		assertEquals(null, pueblo.getCodParadas());
	}
	
	@Test
	public void testConstructorMunicipio() {
		//Arrange
		Municipio pueblo = new Municipio(nombre, codPostal, codParadas);
				
		//Assert
		assertEquals(nombre, pueblo.getNombre());
		assertEquals(codPostal, pueblo.getCodPostal());
		assertEquals(codParadas, pueblo.getCodParadas());
	}
	
	@Test
	public void testNombre() {
		municipio.setNombre(nombre);
		assertEquals(nombre, municipio.getNombre());
	}
	
	@Test
	public void testCodPostal() {
		municipio.setCodPostal(codPostal);
		assertEquals(codPostal, municipio.getCodPostal());
	}
	
	@Test 
	public void testParadas() {
		municipio.setCodParadas(codParadas);
		assertEquals(codParadas, municipio.getCodParadas());
	}

}
