package modeloT;

import static org.junit.Assert.*;
import org.junit.Test;
import modelo.*;


public class TestConexion {	

	@Test
	public void testGetConnectionInfo() {
		
		Conexion conexion = new Conexion();
		
		String[] datosObtenido = conexion.getConnectionInfo();
		String[] datosEsperado = { "localhost", "termibusequipo5", "equipo5", "equipo5" };
		
		assertArrayEquals(datosObtenido, datosEsperado);
	}

}
