package controladorT;

import static org.mockito.Mockito.*;

import org.junit.Test;

import controlador.ControladorPago;
import modelo.Conexion;
import modelo.Consultas;
import modelo.Encriptacion;
import modelo.Ficheros;
import modelo.Modelo;
import modelo.Pagar;
import vista.MainFrame;
public class TestControladorPago {

	@Test
	public void testFuncionBotonDineroDineroMasGrandeTotal() {
		MainFrame vista = new MainFrame();
		Ficheros ficherosMock = mock(Ficheros.class);
		String[] datosConexion = null;
		String[] datosConexionMock = {"ab", "cd", "ef", "gh"};
		when(ficherosMock.getConnectionInfo()).thenReturn(datosConexionMock);
		datosConexion = ficherosMock.getConnectionInfo();
		Conexion conexion = new Conexion(datosConexion);
		Consultas consultas = new Consultas(conexion);
		Encriptacion encriptacion = new Encriptacion();
		Pagar pagarMock = mock(Pagar.class);
		Modelo modelo = new Modelo(ficherosMock, datosConexion, conexion, consultas, encriptacion, pagarMock);
		ControladorPago controladorPago = new ControladorPago(vista, modelo);
		
		controladorPago.dinero = 10f;
		controladorPago.total = 15f;
		float importe = 10f;
		
		controladorPago.FuncionBotonDinero(importe);
	}
	
	@Test
	public void testFuncionBotonDineroDineroMasPequeñoTotal() {
		MainFrame vista = new MainFrame();
		Ficheros ficherosMock = mock(Ficheros.class);
		String[] datosConexion = null;
		String[] datosConexionMock = {"ab", "cd", "ef", "gh"};
		when(ficherosMock.getConnectionInfo()).thenReturn(datosConexionMock);
		datosConexion = ficherosMock.getConnectionInfo();
		Conexion conexion = new Conexion(datosConexion);
		Consultas consultas = new Consultas(conexion);
		Encriptacion encriptacion = new Encriptacion();
		Pagar pagarMock = mock(Pagar.class);
		Modelo modelo = new Modelo(ficherosMock, datosConexion, conexion, consultas, encriptacion, pagarMock);
		ControladorPago controladorPago = new ControladorPago(vista, modelo);
		
		controladorPago.dinero = 10f;
		controladorPago.total = 15f;
		float importe = 1f;
		
		controladorPago.FuncionBotonDinero(importe);
		
		verify(pagarMock, times(1)).Falta(controladorPago.total, controladorPago.dinero);
	}
	
	@Test
	public void testFuncionDevolverDineroMayorQueCeroYMenorQueTotal() {
		MainFrame vista = new MainFrame();
		Ficheros ficherosMock = mock(Ficheros.class);
		String[] datosConexion = null;
		String[] datosConexionMock = {"ab", "cd", "ef", "gh"};
		when(ficherosMock.getConnectionInfo()).thenReturn(datosConexionMock);
		datosConexion = ficherosMock.getConnectionInfo();
		Conexion conexion = new Conexion(datosConexion);
		Consultas consultas = new Consultas(conexion);
		Encriptacion encriptacion = new Encriptacion();
		Pagar pagarMock = mock(Pagar.class);
		Modelo modelo = new Modelo(ficherosMock, datosConexion, conexion, consultas, encriptacion, pagarMock);
		ControladorPago controladorPago = new ControladorPago(vista, modelo);
		
		controladorPago.total = 20f;
		controladorPago.dinero = 10f;
		float[] monedas = {5f, 2f, 2f, 0.5f, 0.5f};
		controladorPago.monedas = monedas;
		controladorPago.FuncionDevolver();
		
		verify(pagarMock, times(1)).Falta(controladorPago.total, controladorPago.dinero);
	}
	
	@Test
	public void testFuncionDevolverDineroMayorQueCeroYMayorQueTotal() {
		MainFrame vista = new MainFrame();
		Ficheros ficherosMock = mock(Ficheros.class);
		String[] datosConexion = null;
		String[] datosConexionMock = {"ab", "cd", "ef", "gh"};
		when(ficherosMock.getConnectionInfo()).thenReturn(datosConexionMock);
		datosConexion = ficherosMock.getConnectionInfo();
		Conexion conexion = new Conexion(datosConexion);
		Consultas consultas = new Consultas(conexion);
		Encriptacion encriptacion = new Encriptacion();
		Pagar pagarMock = mock(Pagar.class);
		Modelo modelo = new Modelo(ficherosMock, datosConexion, conexion, consultas, encriptacion, pagarMock);
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
		Ficheros ficherosMock = mock(Ficheros.class);
		String[] datosConexion = null;
		String[] datosConexionMock = {"ab", "cd", "ef", "gh"};
		when(ficherosMock.getConnectionInfo()).thenReturn(datosConexionMock);
		datosConexion = ficherosMock.getConnectionInfo();
		Conexion conexion = new Conexion(datosConexion);
		Consultas consultas = new Consultas(conexion);
		Encriptacion encriptacion = new Encriptacion();
		Pagar pagarMock = mock(Pagar.class);
		Modelo modelo = new Modelo(ficherosMock, datosConexion, conexion, consultas, encriptacion, pagarMock);
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
		Ficheros ficherosMock = mock(Ficheros.class);
		String[] datosConexion = null;
		String[] datosConexionMock = {"ab", "cd", "ef", "gh"};
		when(ficherosMock.getConnectionInfo()).thenReturn(datosConexionMock);
		datosConexion = ficherosMock.getConnectionInfo();
		Conexion conexion = new Conexion(datosConexion);
		Consultas consultas = new Consultas(conexion);
		Encriptacion encriptacion = new Encriptacion();
		Pagar pagarMock = mock(Pagar.class);
		Modelo modelo = new Modelo(ficherosMock, datosConexion, conexion, consultas, encriptacion, pagarMock);
		ControladorPago controladorPago = new ControladorPago(vista, modelo);
		
		controladorPago.total = 20f;
		controladorPago.dinero = 25f;
		controladorPago.FuncionContinuar();
		
		verify(pagarMock, times(1)).Sobra(controladorPago.total, controladorPago.dinero);
	}

}
