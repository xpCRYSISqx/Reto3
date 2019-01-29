package app;

import controlador.Controlador;
import modelo.Modelo;
import vista.*;

public class App {

	public static void main(String[] args) {
		
		Modelo modelo = new Modelo();
		MainFrame vista = new MainFrame();
		Controlador controlador = new Controlador(modelo, vista);
		controlador.inicializarEventos();
	}
}