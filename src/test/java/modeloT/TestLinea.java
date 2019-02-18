package modeloT;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import modelo.*;

public class TestLinea {
	
	private String codLinea = "L66";
	private String nombre = "Zeca-Meca";
	private ArrayList<Autobus> autobuses = new ArrayList<Autobus>();
	private ArrayList<Municipio> municipios = new ArrayList<Municipio>();
	private Linea linea = new Linea();
	
	@Test
	public void testConstructorVacioLinea() {
		//Arrange
		Linea linea = new Linea();
				
		//Assert
		assertEquals(null, linea.getCodLinea());
		assertEquals(null, linea.getNombre());
		assertEquals(null, linea.getAutobuses());
		assertEquals(null, linea.getMunicipios());
	}
	
	@Test
	public void testConstructorLinea() {
		//Arrange
		Linea linea = new Linea(codLinea,nombre, autobuses, municipios);
				
		//Assert
		assertEquals(codLinea, linea.getCodLinea());
		assertEquals(nombre, linea.getNombre());
		assertEquals(autobuses, linea.getAutobuses());
		assertEquals(municipios, linea.getMunicipios());
	}
	
	@Test
	public void testCodLinea() {
		linea.setCodLinea(codLinea);
		assertEquals(codLinea, linea.getCodLinea());
	}

	@Test
	public void testNombre() {
		linea.setNombre(nombre);
		assertEquals(nombre, linea.getNombre());
	}
	
	@Test
	public void testAutobuses() {
		linea.setAutobuses(autobuses);
		assertEquals(autobuses, linea.getAutobuses());
	}
	
	@Test
	public void testMunicipios() {
		linea.setMunicipios(municipios);
		assertEquals(municipios, linea.getMunicipios());
	}
	
	@Test
	public void testToString() {
		linea.setCodLinea(codLinea);
		linea.setNombre(nombre);
		assertEquals("Linea " + codLinea + ": " + nombre, linea.toString());
	}
	

}
