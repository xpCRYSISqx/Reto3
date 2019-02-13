package modeloT;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;
import org.junit.Test;
import modelo.Billete;

public class TestBillete {

	@Test
	public void testConstructorVacioBillete() {
		//Arrange
		Billete billete = new Billete();
		
		//Assert
		assertEquals(billete.getCodBillete(),0);
		assertEquals(billete.getNTrayecto(),0);
		assertEquals(billete.getCodLinea(),null);
		assertEquals(billete.getCodBus(),0);
		assertEquals(billete.getCodParadaInicio(),0);
		assertEquals(billete.getCodParadaFin(),0);
		assertEquals(billete.getFecha(),null);
		assertEquals(billete.getHora(),null);
		assertEquals(billete.getDni(),null);
		assertEquals(billete.getPrecio(),0f,0);
	}
	
	@Test
	public void testConstructorBillete() {
		Date date = new Date(31-01-2019);
		Time time = new Time(0);
		long a = date.getTime();
		
		//Arrange
		Billete billete = new Billete(001,21,"L4",99,1212,1414,date,time,"45669566F",22.50f);
				
		//Assert
		assertEquals(billete.getCodBillete(),001);
		assertEquals(billete.getNTrayecto(),21);
		assertEquals(billete.getCodLinea(),"L4");
		assertEquals(billete.getCodBus(),99);
		assertEquals(billete.getCodParadaInicio(),1212);
		assertEquals(billete.getCodParadaFin(),1414);
		assertEquals(billete.getFecha(),date);
		assertEquals(billete.getHora(),time);
		assertEquals(billete.getDni(),"45669566F");
		assertEquals(billete.getPrecio(),22.50f,0);
	}

}
