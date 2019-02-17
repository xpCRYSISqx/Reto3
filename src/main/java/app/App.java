package app;

import static org.junit.Assert.assertEquals;

import controlador.Controlador;
import modelo.Conexion;
import modelo.Consultas;
import modelo.Funciones;
import modelo.Modelo;
import vista.MainFrame;

public class App {

	public static void main(String[] args) {
		
		Funciones funciones = new Funciones();
		
		MainFrame vista = new MainFrame();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(modelo, vista);
		
		controlador.inicializarInterfaz();
		controlador.inicializarBotones();
		

		float total = 85.7f;
		float dinero = 83.5f;
		float falta = Math.round((total-dinero)*100);
		
		System.out.println(falta/100);	
	}
}