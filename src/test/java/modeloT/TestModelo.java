package modeloT;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.mock;

import modelo.Conexion;
import modelo.Consultas;
import modelo.Modelo;

public class TestModelo {

	@Test
	public void testConstructor() {
		
		Conexion conexionMock = mock(Conexion.class);
		Consultas consultasMock = mock(Consultas.class);

		//Arrange
		Modelo modelo = new Modelo();
		
		//Assert
		assertEquals(conexionMock, modelo.conexion);
		assertEquals(consultasMock, modelo.consultas);
		assertEquals(null, modelo.cliente);	
		assertEquals(null, modelo.cliente);
		assertEquals(null, modelo.billeteIda);
		assertEquals(null, modelo.billeteVuelta);
		assertEquals(null, modelo.linea);
		assertEquals(null, modelo.paradaOrigen);
		assertEquals(null, modelo.paradaDestino);
		assertEquals(null, modelo.autobus);
		assertEquals(0, modelo.precioTotal, 0);
	}

}
