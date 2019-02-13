package modeloT;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;
import modelo.Cliente;


public class TestCliente {

	@Test
	public void testConstructorVacioCliente() {
		//Arrange
		Cliente cliente = new Cliente();
		
		//Assert
		assertEquals(cliente.getDni(),null);
		assertEquals(cliente.getNombre(),null);
		assertEquals(cliente.getApellidos(),null);
		assertEquals(cliente.getFechaNacimiento(),null);
		assertEquals(cliente.getSexo(),0);
		assertEquals(cliente.getContraseña(),null);
	}
	
	@Test
	public void testConstructorCliente() {
		Date date = new Date(28-11-1990);
		
		//Arrange
		Cliente cliente = new Cliente("45669566X","Shalke","Themeto", date, 'm', "abracadaver");
		
		//Assert
		assertEquals(cliente.getDni(),"45669566X");
		assertEquals(cliente.getNombre(),"Shalke");
		assertEquals(cliente.getApellidos(),"Themeto");
		assertEquals(cliente.getFechaNacimiento(),date);
		assertEquals(cliente.getSexo(),'m'); 
		assertEquals(cliente.getContraseña(),"abracadaver");
	}
}
