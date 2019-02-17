package modeloT;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;
import modelo.*;


public class TestConexion {	

	@Test
	public void testGetConnectionInfo() {
		
		Conexion conexion = new Conexion();
		
		String[] datosObtenido = conexion.getConnectionInfo();
		String[] datosEsperado = { "localhost", "termibusequipo5", "equipo5", "equipo5" };
		
		assertArrayEquals(datosObtenido, datosEsperado);
	}
	
	
	
	
	

//	@Test //Linea 376
//	public void testCalcularPrecioBillete() {
//		float precio = 0, distancia = 22.2f, consumo = 10.5f, beneficio = 100.90f;
//		Autobus autocar = mock(Autobus.class);
//		Consultas consultas = new Consultas(Conexion);
//		consumo = 
//	}
//	
//	@Test //Linea 401
//	public void testCalcularDistanciaKm() {
//		
//	}

}
