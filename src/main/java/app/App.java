package app;

import controlador.Controlador;
import modelo.Modelo;
import vista.MainFrame;

public class App {

	public static void main(String[] args) {
		
		// Instancia de las clases necesarias para el programa
		MainFrame vista = new MainFrame();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(modelo, vista);
		
		controlador.inicializarEventos();		
		controlador.inicializarInterfaz();
	}
}