package app;

import controlador.Controlador;
import modelo.Modelo;
import vista.MainFrame;

public class App {

	/**
	 * 
	 * @param args Argumentos que se le pasan al main
	 */
	public static void main(String[] args) {
		
		MainFrame vista = new MainFrame();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(modelo, vista);
		
		controlador.inicializarInterfaz();
		controlador.inicializarBotones();
	}
}