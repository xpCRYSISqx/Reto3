package modeloT;

import static org.junit.Assert.*;
import org.junit.Test;
import java.sql.Date;
import modelo.Billete;

public class TestBillete {
	
	private int codBillete = 001;
	private int nTrayecto = 1;
	private String codLinea = "L4";
	private int codBus = 99;
	private int codParadaInicio = 1;
	private int codParadaFin = 2;
	private Date fecha = new Date(31-01-2019);
	private String hora = "11:00";
	private String dni = "12345678X";
	private float precio = 22.5f;
	private Billete billete = new Billete();

	@Test
	public void testConstructorVacioBillete() {
		//Arrange
		Billete billete = new Billete();
		
		//Assert
		assertEquals(0, billete.getCodBillete());
		assertEquals(0, billete.getNTrayecto());
		assertEquals(null, billete.getCodLinea());
		assertEquals(0, billete.getCodBus());
		assertEquals(0, billete.getCodParadaInicio());
		assertEquals(0, billete.getCodParadaFin());
		assertEquals(null, billete.getFecha());
		assertEquals(null, billete.getHora());
		assertEquals(null, billete.getDni());
		assertEquals(0f, billete.getPrecio(),0);
	}
	
	@Test
	public void testConstructorBillete() {
		
		//Arrange
		Billete billete = new Billete(codBillete,nTrayecto,codLinea,codBus,codParadaInicio,codParadaFin,fecha,hora,dni,precio);
				
		//Assert
		assertEquals(codBillete, billete.getCodBillete());
		assertEquals(nTrayecto, billete.getNTrayecto());
		assertEquals(codLinea, billete.getCodLinea());
		assertEquals(codBus, billete.getCodBus());
		assertEquals(codParadaInicio, billete.getCodParadaInicio());
		assertEquals(codParadaFin, billete.getCodParadaFin());
		assertEquals(fecha, billete.getFecha());
		assertEquals(hora, billete.getHora());
		assertEquals(dni, billete.getDni());
		assertEquals(precio, billete.getPrecio(),0);
	}
	
	@Test
	public void testCodBillete() {
		billete.setCodBillete(codBillete);
		assertEquals(codBillete, billete.getCodBillete());
	}
	
	@Test
	public void testNumTrayecto() {
		billete.setNTrayecto(nTrayecto);
		assertEquals(nTrayecto, billete.getNTrayecto());
	}

	@Test
	public void testCodLinea() {
		billete.setCodLinea(codLinea);
		assertEquals(codLinea, billete.getCodLinea());
	}

	@Test
	public void testCodBus() {
		billete.setCodBus(codBus);
		assertEquals(codBus, billete.getCodBus());
	}

	@Test
	public void testCodParadaInicio() {
		billete.setCodParadaInicio(codParadaInicio);
		assertEquals(codParadaInicio, billete.getCodParadaInicio());
	}

	@Test
	public void testCodParadaFin() {
		billete.setCodParadaFin(codParadaFin);
		assertEquals(codParadaFin, billete.getCodParadaFin());
	}

	@Test
	public void testFecha() {
		billete.setFecha(fecha);
		assertEquals(fecha, billete.getFecha());
	}
	
	@Test
	public void testHora() {
		billete.setHora(hora);
		assertEquals(hora, billete.getHora());
	}

	@Test
	public void testDni() {
		billete.setDni(dni);
		assertEquals(dni, billete.getDni());
	}

	@Test
	public void testPrecio() {
		billete.setPrecio(precio);
		assertEquals(billete.getPrecio(), precio, 0);
	}

}
