package modeloT;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import modelo.*;

public class TestLinea {

	ArrayList<Autobus> autobuses = new ArrayList<Autobus>();
	ArrayList<Municipio> municipios = new ArrayList<Municipio>();
	
	@Test
	public void testConstructorVacioLinea() {
		//Arrange
		Linea linea = new Linea();
				
		//Assert
		assertEquals(linea.getCodLinea(),null);
		assertEquals(linea.getNombre(),null);
		assertEquals(linea.getAutobuses(),null);
		assertEquals(linea.getMunicipios(),null);
	}
	
	@Test
	public void testConstructorLinea() {
		//Arrange
		Linea linea = new Linea("L66","Zeca-Meca", autobuses, municipios);
				
		//Assert
		assertEquals(linea.getCodLinea(),"L66");
		assertEquals(linea.getNombre(),"Zeca-Meca");
		assertEquals(linea.getAutobuses(),autobuses);
		assertEquals(linea.getMunicipios(),municipios);
	}

}
