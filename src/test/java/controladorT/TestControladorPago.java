package controladorT;

import static org.mockito.Mockito.*;

import org.junit.Test;

import controlador.ControladorPago;

import modelo.FuncionesPago;
import modelo.Modelo;
import vista.MainFrame;
public class TestControladorPago {

	@Test
	public void testFuncionBotonDineroDineroMasGrandeTotal() {
		MainFrame vista = new MainFrame();
		Modelo modelo = new Modelo();
		ControladorPago controladorPago = new ControladorPago(vista, modelo);
		
		controladorPago.dinero = 10f;
		controladorPago.total = 15f;
		float importe = 10f;
		
		controladorPago.FuncionBotonDinero(importe);
	}
	
	@Test
	public void testFuncionBotonDineroDineroMasPequeñoTotal() {
		MainFrame vista = new MainFrame();
		Modelo modelo = new Modelo();
		ControladorPago controladorPago = new ControladorPago(vista, modelo);
		FuncionesPago pagarMock = mock(FuncionesPago.class);
		
		float importe = 1f;
		controladorPago.dinero = 10f;
		controladorPago.total = 15f;
		
		controladorPago.FuncionBotonDinero(importe);
		
		verify(pagarMock, times(1)).falta(controladorPago.total, controladorPago.dinero);
	}
	
	@Test
	public void testFuncionDevolverDineroMayorQueCeroYMenorQueTotal() {
		MainFrame vista = new MainFrame();
		Modelo modelo = new Modelo();
		ControladorPago controladorPago = new ControladorPago(vista, modelo);
		FuncionesPago pagarMock = mock(FuncionesPago.class);
		
		controladorPago.total = 20f;
		controladorPago.dinero = 10f;
		float[] monedas = {5f, 2f, 2f, 0.5f, 0.5f};
		controladorPago.monedas = monedas;
		controladorPago.FuncionDevolver();
		
		verify(pagarMock, times(1)).falta(controladorPago.total, controladorPago.dinero);
	}
	
	@Test
	public void testFuncionDevolverDineroMayorQueCeroYMayorQueTotal() {
		MainFrame vista = new MainFrame();
		Modelo modelo = new Modelo();
		ControladorPago controladorPago = new ControladorPago(vista, modelo);
		
		controladorPago.total = 20f;
		controladorPago.dinero = 25f;
		float[] monedas = {5f, 2f, 2f, 10f, 1f};
		controladorPago.monedas = monedas;
		controladorPago.FuncionDevolver();
	}
	
	@Test
	public void testFuncionDevolverDineroIgualACero() {
		MainFrame vista = new MainFrame();
		Modelo modelo = new Modelo();
		ControladorPago controladorPago = new ControladorPago(vista, modelo);
		
		controladorPago.total = 20f;
		controladorPago.dinero = 0f;
		float[] monedas = new float[0];
		controladorPago.monedas = monedas;
		controladorPago.FuncionDevolver();
	}
	
	@Test
	public void testFuncionContinuar() {
		MainFrame vista = new MainFrame();
		Modelo modelo = new Modelo();
		ControladorPago controladorPago = new ControladorPago(vista, modelo);
		FuncionesPago pagarMock = mock(FuncionesPago.class);
		
		controladorPago.total = 20f;
		controladorPago.dinero = 25f;
		controladorPago.FuncionContinuar();
		
		verify(pagarMock, times(1)).sobra(controladorPago.total, controladorPago.dinero);
	}

}
