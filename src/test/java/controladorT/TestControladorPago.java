package controladorT;

import static org.mockito.Mockito.*;

import org.junit.Test;

import controlador.ControladorPago;
import modelo.Billete;
import modelo.Pagar;
import vista.MainFrame;
public class TestControladorPago {

	@Test
	public void testFuncionBotonDineroDineroMasGrandeTotal() {
		MainFrame vista = new MainFrame();
		Billete billete = new Billete();
		Pagar pagarMock = mock(Pagar.class);
		ControladorPago controladorPago = new ControladorPago(vista, billete, pagarMock);
		
		controladorPago.dinero = 10;
		controladorPago.total = 15;
		float importe = 10f;
		
		controladorPago.FuncionBotonDinero(importe);
		
		verify(pagarMock, times(1)).Sobra(controladorPago.total, controladorPago.dinero);
	}
	
	@Test
	public void testFuncionBotonDineroDineroMasPequeñoTotal() {
		MainFrame vista = new MainFrame();
		Billete billete = new Billete();
		Pagar pagarMock = mock(Pagar.class);
		ControladorPago controladorPago = new ControladorPago(vista, billete, pagarMock);
		
		controladorPago.dinero = 10;
		controladorPago.total = 15;
		float importe = 1f;
		
		controladorPago.FuncionBotonDinero(importe);
		
		verify(pagarMock, times(1)).Falta(controladorPago.total, controladorPago.dinero);
	}
	
	@Test
	public void testFuncionDevolverDineroMayorQueCeroYMenorQueTotal() {
		MainFrame vista = new MainFrame();
		Billete billete = new Billete();
		Pagar pagarMock = mock(Pagar.class);
		ControladorPago controladorPago = new ControladorPago(vista, billete, pagarMock);
		
		controladorPago.total = 20;
		controladorPago.dinero = 10;
		float[] monedas = {5, 2, 2, 0.5f, 0.5f};
		controladorPago.monedas = monedas;
		controladorPago.FuncionDevolver();
		
		verify(pagarMock, times(1)).Falta(controladorPago.total, controladorPago.dinero);
	}
	
	@Test
	public void testFuncionDevolverDineroMayorQueCeroYMayorQueTotal() {
		MainFrame vista = new MainFrame();
		Billete billete = new Billete();
		Pagar pagarMock = mock(Pagar.class);
		ControladorPago controladorPago = new ControladorPago(vista, billete, pagarMock);
		
		controladorPago.total = 20;
		controladorPago.dinero = 25;
		float[] monedas = {5, 2, 2, 10, 1};
		controladorPago.monedas = monedas;
		controladorPago.FuncionDevolver();
		
		verify(pagarMock, times(1)).Sobra(controladorPago.total, controladorPago.dinero);
	}
	
	@Test
	public void testFuncionDevolverDineroIgualACero() {
		MainFrame vista = new MainFrame();
		Billete billete = new Billete();
		Pagar pagarMock = mock(Pagar.class);
		ControladorPago controladorPago = new ControladorPago(vista, billete, pagarMock);
		
		controladorPago.total = 20;
		controladorPago.dinero = 0;
		float[] monedas = new float[0];
		controladorPago.monedas = monedas;
		controladorPago.FuncionDevolver();
	}

}
