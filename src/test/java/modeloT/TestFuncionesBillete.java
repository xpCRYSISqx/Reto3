package modeloT;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;
import modelo.*;

public class TestFuncionesBillete {
	
	Modelo modelo = new Modelo();
	FuncionesBillete funcionesBillete = new FuncionesBillete(modelo);
	
	@Test
	public void testCalcularPrecioTrayecto() {
		
		Autobus autobusMock = mock(Autobus.class);
		when(autobusMock.getConsumo()).thenReturn(2f);
		float consumo = 2f;
		float distancia = 2f;
		float beneficio = 1.2f;
		float iva = 1.21f;
		
		// calculamos el precio
		float precio = consumo * distancia * beneficio * iva;
		
		assertEquals(precio, funcionesBillete.calcularPrecioTrayecto(autobusMock, distancia), 0.01);
	}
	
	@Test
	public void testCalcularDistanciaKm() {
		
		float lat1 = 43.2614f;
		float long1 = -2.94974f;
		float lat2 = 43.4055f;
		float long2 = -2.96369f;
		float distancia = 16.062885f;
		
		assertEquals(distancia, funcionesBillete.calcularDistanciaKm(lat1, long1, lat2, long2), 0);	
	}
	
	@Test
	public void testDeg2Rad() {
		float deg = 10f;
		assertEquals(0.1745329252f, funcionesBillete.deg2rad(deg), 0);	
	}
	
	
}