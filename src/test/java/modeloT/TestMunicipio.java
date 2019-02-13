package modeloT;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import modelo.Municipio;
import modelo.Parada;

public class TestMunicipio {
	
	ArrayList<Integer> paradas = new ArrayList<Integer>(); 

	@Test
	public void testConstructorVacioMunicipio() {
		//Arrange
		Municipio pueblo = new Municipio();
				
		//Assert
		assertEquals(pueblo.getNombre(),null);
		assertEquals(pueblo.getCodPostal(),0);
		assertEquals(pueblo.getCodParadas(),null);
	}
	
	@Test
	public void testConstructorMunicipio() {
		//Arrange
		Municipio pueblo = new Municipio("Migaralles", 48490, paradas);
				
		//Assert
		assertEquals(pueblo.getNombre(),"Migaralles");
		assertEquals(pueblo.getCodPostal(),48490);
		assertEquals(pueblo.getCodParadas(),paradas);
	}

}
