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
		
		//verify(pagarMock, times(1)).Falta(controladorPago.total, controladorPago.dinero);
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

}
