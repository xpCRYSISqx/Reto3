package modeloT;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;
import modelo.*;

public class TestFunciones {
	
	Funciones funciones = new Funciones();
	
	@Test
	public void testValidarDNI() {
		String dni = "72317852X";
		assertEquals(true, funciones.validarDNI(dni));
	}
	
	@Test
	public void testValidarDNIError() {
		String dni = "12317852X";
		assertNotEquals(true, funciones.validarDNI(dni));
	}
	
	@Test
	public void testSoloNumeros() {
		String dni = "72317852X";
		assertEquals(true, funciones.soloNumeros(dni));
	}
	
	@Test
	public void testSoloNumerosError() {
		String dni = "123178ffX";
		assertNotEquals(true, funciones.soloNumeros(dni));
	}
	
	@Test
	public void testLetraDNI() {
		String dni = "72317852X";
		String letraMayuscula = (dni.substring(8)).toUpperCase();
		assertEquals(letraMayuscula, funciones.letraDNI(dni));
	}
	
	@Test
	public void testLetraDNIError() {
		String dni = "12317852B";
		String letraMayuscula = (dni.substring(8)).toUpperCase();
		assertNotEquals(letraMayuscula, funciones.letraDNI(dni));
	}

	@Test
	public void testEncriptacion() {
		
		String contraseña = "abracadabra";
		String contraseñaEncriptada = "ec5287c45f0e70ec22d52e8bcbeeb640";
		
		assertEquals(contraseñaEncriptada, funciones.encriptacion(contraseña));
	}
	
	@Test
	public void testRedimensionarArrayMayor() {
		
		float[] array = new float[0];
		array = funciones.redimensionarArrayMayor(array);
		
		assertEquals(1, array.length);
	}
	
	@Test
	public void testRedimensionarArrayMenor() {
		
		float[] array = new float[2];
		array = funciones.redimensionarArrayMenor(array);
		
		assertEquals(1, array.length);
	}
	
	@Test
	public void testCalcularPrecioBillete() {
		
		Autobus autobusMock = mock(Autobus.class);
		when(autobusMock.getConsumo()).thenReturn(2f);
		float consumo = 2f;
		float distancia = 2f;
		float beneficio = 1.2f;
		float iva = 1.21f;
		
		// calculamos el precio
		float precio = consumo * distancia * beneficio * iva;
		
		assertEquals(precio, funciones.calcularPrecioBillete(autobusMock, distancia), 0.01);
	}
	
	@Test
	public void testCalcularDistanciaKm() {
		
		float lat1 = 43.2614f;
		float long1 = -2.94974f;
		float lat2 = 43.4055f;
		float long2 = -2.96369f;
		float distancia = 16.062885f;
		
		assertEquals(distancia, funciones.calcularDistanciaKm(lat1, long1, lat2, long2), 0);	
	}
	
	@Test
	public void testDeg2Rad() {
		float deg = 10f;
		assertEquals(0.1745329252f, funciones.deg2rad(deg), 0);	
	}
	
	@Test
	public void testFalta() {
		
		float total = 85.7f;
		float dinero = 83.5f;
		float falta = 2.2f;
		
		assertEquals(falta, funciones.falta(total, dinero), 0);	
	}
	
//	@Test
//	public void testSobra() {
//		
//		float total = 83.5f;
//		float dinero = 85.5f;
//		float falta = Math.round((total-dinero)*100)/100;
//		
//		assertEquals(falta, funciones.sobra(total, dinero), 0);	
//	}
	
	
}