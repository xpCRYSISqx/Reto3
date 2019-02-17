package modeloT;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;
import modelo.*;

public class TestFuncionesPago {
	
	Modelo modelo = new Modelo();
	FuncionesPago funcionesPago = new FuncionesPago(modelo);
	
	@Test
	public void testRedimensionarArrayMayor() {
		
		float[] array = new float[0];
		array = funcionesPago.redimensionarArrayMayor(array);
		
		assertEquals(1, array.length);
	}
	
	@Test
	public void testRedimensionarArrayMenor() {
		
		float[] array = new float[2];
		array = funcionesPago.redimensionarArrayMenor(array);
		
		assertEquals(1, array.length);
	}
	
	@Test
	public void testFalta() {
		
		float total = 85.7f;
		float dinero = 83.5f;
		float falta = 2.2f;
		
		assertEquals(falta, funcionesPago.falta(total, dinero), 0);	
	}
	
//	@Test
//	public void testSobra() {
//		
//		float total = 83.5f;
//		float dinero = 85.5f;
//		float falta = Math.round((total-dinero)*100)/100;
//		
//		assertEquals(falta, funcionesPago.sobra(total, dinero), 0);	
//	}
	
	
}